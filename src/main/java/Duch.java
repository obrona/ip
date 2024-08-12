import java.util.ArrayList;
import java.util.Scanner;

public class Duch {
    Printer p = new Printer();
    ArrayList<Task> tasks = new ArrayList<>();

    public void add(String text) {
        tasks.add(new Task(text));
        p.print("added: " + text + '\n');
    }

    public void list() {
        String out = "Here are the tasks in your list\n";
        for (int i = 0; i < tasks.size(); i ++) {
            out += (i + 1) + ": " + tasks.get(i).toString() + '\n';
        }
        p.print(out);
    }

    public void mark(int idx) {
        idx --;
        tasks.get(idx).setDone(true);
        String out = "Nice! I've marked this task as done:\n" + " " + tasks.get(idx).toString() + '\n';
        p.print(out);
    }

    public void unmark(int idx) {
        idx --;
        tasks.get(idx).setDone(false);
        String out = "OK, I've marked this task as not done yet:\n" + " " + tasks.get(idx).toString() + '\n';
        p.print(out);
    }


    public static void main(String[] args) {
        Duch duch = new Duch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        while (true) {
            String text = scanner.nextLine();
            String[] arr = text.split(" ");
           if (arr[0].equals("bye")) break;
           else if (arr[0].equals("list")) duch.list();
           else if (arr[0].equals("mark")) duch.mark(Integer.parseInt(arr[1]));
           else if (arr[0].equals("unmark")) duch.unmark(Integer.parseInt(arr[1]));
           else duch.add(text);


        }
        scanner.close();
        System.out.println("Bye. Hope to see you again");
    }
}
