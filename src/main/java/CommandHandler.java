import java.util.*;
import Task.*;


public class CommandHandler {
    ArrayList<Task> tasks = new ArrayList<>();
    Printer p = new Printer();

    CommandHandler(ArrayList<Task> lst) {
        tasks = lst;
    }

    String concat(String[] arr, int s, int e) {
        String out = "";
        for (int i = s; i < e; i ++) {
            if (out.equals("")) out += arr[i];
            else out += " " + arr[i];
        }
        return out;
    }
    
    int find(String[] arr, String s) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i].equals(s)) return i;
        }
        return -1;
    }

    void printAddTask(Task t) {
         p.print("Got it. I've added this task\n  " + t.toString() + "\nNow you have " + tasks.size() + " tasks in the list\n");
    }

    void printMark(Task t) {
        p.print("Nice! I have marked this task as done:\n  " + t.toString()+ "\n");
    }

    void printUnMark(Task t) {
        p.print("OK, I've marked this task as not done yet:\n  " + t.toString() + "\n");
    }

    void printDelete(Task t) {
        p.print("Noted. I have removed this task\n  " + t.toString() + "\n");
    }

    void todo(String[] arr) throws DuchException {
        if (arr.length == 1) throw new DuchException("The description of todo cannot be empty");
        
        Todo t = new Todo(concat(arr, 1, arr.length));
        tasks.add(t);
        printAddTask(t);
    }

    void deadline(String[] arr) throws DuchException {
        int byIdx = find(arr, "/by");
        if (byIdx == -1) throw new DuchException("/by date is not found");
        
        Task t = new Deadline(concat(arr, 1, byIdx), concat(arr, byIdx + 1, arr.length));
        tasks.add(t);
        printAddTask(t);
    }

    void event(String[] arr) throws DuchException {
        int fromIdx = find(arr, "/from");
        int toIdx = find(arr, "/to");
        if (fromIdx == -1 || toIdx == -1) throw new DuchException("/from date (and/or) /to date is not found");
        
        Event t = new Event(concat(arr, 1, fromIdx), concat(arr, fromIdx + 1, toIdx), concat(arr, toIdx + 1, arr.length));
        tasks.add(t);
        printAddTask(t);
    }

    void list(String[] arr) {
        String out = "";
        for (int i = 0; i < tasks.size(); i ++) {
            out += (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        p.print(out);
    }

    void mark(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        t.setDone(true);
        printMark(t);
    }

    void unmark(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        t.setDone(false);
        printUnMark(t);
    }

    void delete(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        printDelete(t);
        tasks.remove(idx - 1);
    }

    void handleCommand(String cmd) throws DuchException {
        String[] splitted = cmd.split(" ");
        String action = splitted[0];
        if (action.equals("list")) list(splitted);
        else if (action.equals("todo")) todo(splitted);
        else if (action.equals("deadline")) deadline(splitted);
        else if (action.equals("event")) event(splitted);
        else if (action.equals("mark")) mark(splitted);
        else if (action.equals("unmark")) unmark(splitted);
        else if (action.equals("delete")) delete(splitted);
        else throw new DuchException("Invalid Command. Please re-enter command");
        
    }

    /*public static void main(String[] args) {
        CommandHandler c = new CommandHandler();
        c.handleCommand("event exam /from Mon /to Sun");
    }*/
    
   
}
