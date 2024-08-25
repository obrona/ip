package Duch;

import Duch.Task.*;

/**
 * Parse commands received from the CLI
 * 
 */
public class Parser {
    TaskList tasks = new TaskList();
    Ui p = new Ui();

    public Parser(TaskList lst) {
        tasks = lst;
    }

    /**
     * concat strings in indexes [s, e), with spaces between the words
     * 
     * @param arr the array
     * @param s start index
     * @param e end index
     * @return concated string
     */
    public String concat(String[] arr, int s, int e) {
        String out = "";
        for (int i = s; i < e; i ++) {
            if (out.equals("")) out += arr[i];
            else out += " " + arr[i];
        }
        return out;
    }
    
    private int find(String[] arr, String s) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i].equals(s)) return i;
        }
        return -1;
    }

    private void printAddTask(Task t) {
        p.print("Got it. I've added this task\n  " + t.toString() + "\nNow you have " + tasks.size() + " tasks in the list\n");
    }

    private void printMark(Task t) {
        p.print("Nice! I have marked this task as done:\n  " + t.toString()+ "\n");
    }

    private void printUnMark(Task t) {
        p.print("OK, I've marked this task as not done yet:\n  " + t.toString() + "\n");
    }

    private void printDelete(Task t) {
        p.print("Noted. I have removed this task\n  " + t.toString() + "\n");
    }

    /**
     * Parse a todo command
     * 
     * @param arr The splitted arr
     * @throws DuchException If command is invalid
     */
    public void todo(String[] arr) throws DuchException {
        if (arr.length == 1) {
            throw new DuchException("The description of todo cannot be empty");
        }
        
        Todo t = new Todo(concat(arr, 1, arr.length));
        tasks.add(t);
        printAddTask(t);
    }

    /**
     * parse a deadline command 
     * 
     * @param arr The splitted arr
     * @throws DuchException If command is invalid
     */
    public void deadline(String[] arr) throws DuchException {
        int byIdx = find(arr, "/by");
        if (byIdx == -1) {
            throw new DuchException("/by date is not found");
        }
        
        String task = concat(arr, 1, byIdx);
        String by = concat(arr, byIdx + 1, arr.length);
        if (task.equals("")) {
            throw new DuchException("The description of deadline cannot be empty");
        }
        
        Task t = new Deadline(task, by);
        tasks.add(t);
        printAddTask(t);
    }

    /**
     * Parse an event command
     * 
     * @param arr The splitted arr
     * @throws DuchException If command is invalid
     */
    public void event(String[] arr) throws DuchException {
        int fromIdx = find(arr, "/from");
        int toIdx = find(arr, "/to");
        if (fromIdx == -1 || toIdx == -1) {
            throw new DuchException("/from date (and/or) /to date is not found");
        }

        String task = concat(arr, 1, fromIdx);
        String from = concat(arr, fromIdx + 1, toIdx);
        String to = concat(arr, toIdx + 1, arr.length);
        if (task.equals("")) {
            throw new DuchException("The description of event cannot be empty");
        }
        
        Event t = new Event(task, from, to);
        tasks.add(t);
        printAddTask(t);
    }

    /**
     * Parse a list command
     * 
     * @param arr The splitted arr
     */
    public void list(String[] arr) {
        String out = "";
        for (int i = 0; i < tasks.size(); i ++) {
            out += (i + 1) + "." + tasks.get(i).toString() + "\n";
        }
        p.print(out);
    }

    /**
     * Parse a mark command
     * 
     * @param arr The splitted arr
     */
    public void mark(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        t.setDone(true);
        printMark(t);
    }

    /**
     * Parse a unmark command
     * 
     * @param arr The splitted command
     */
    public void unmark(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        t.setDone(false);
        printUnMark(t);
    }

    /**
     * Parse a delete command
     * 
     * @param arr The splitted command
     */
    public void delete(String[] arr) {
        int idx = Integer.parseInt(arr[1]);
        Task t = tasks.get(idx - 1);
        printDelete(t);
        tasks.remove(idx - 1);
    }

    public void handleCommand(String cmd) throws DuchException {
        String[] splitted = cmd.split(" ");
        String action = splitted[0];
        if (action.equals("list")) {
            list(splitted);
        } else if (action.equals("todo")) {
            todo(splitted);
        } else if (action.equals("deadline")) {
            deadline(splitted);
        } else if (action.equals("event")) {
            event(splitted);
        } else if (action.equals("mark")) {
            mark(splitted);
        } else if (action.equals("unmark")) {
            unmark(splitted);
        } else if (action.equals("delete")) {
            delete(splitted);
        } else {
            throw new DuchException("Invalid Command. Please re-enter command");
        }
    }

    /*public static void main(String[] args) {
        CommandHandler c = new CommandHandler();
        c.handleCommand("event exam /from Mon /to Sun");
    }*/
    
   
}
