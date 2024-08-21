import java.util.Scanner;
import java.util.*;
import Task.*;



public class Duch {
    ArrayList<Task> tasks = new ArrayList<>();
    Printer printer = new Printer();
    CommandHandler commandHandler = new CommandHandler(tasks);
    Storage storageHandler = new Storage(tasks);

    public static void main(String[] args) {
        Duch duch = new Duch();
        duch.storageHandler.openFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        System.out.println("Please input your dates in d/MM/yyyy HHmm");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("bye")) break;
            
            try {
                duch.commandHandler.handleCommand(text);
            } catch (Exception e) {
                duch.printer.print(e.getMessage() + "\n");
            }
        }    
         
        
        scanner.close();
        duch.storageHandler.saveTasks();
        System.out.println("Bye. Hope to see you again");
    }
}
