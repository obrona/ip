import java.time.DateTimeException;
import java.util.Scanner;

import Duch.Parser;
import Duch.Storage;
import Duch.TaskList;
import Duch.Ui;




public class Duch {
    TaskList tasks = new TaskList();
    Ui printer = new Ui();
    Parser commandHandler = new Parser(tasks);
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
            } catch (DateTimeException e) {
                duch.printer.print("Invalid Date Format\n");
            } catch (Exception e) {
                duch.printer.print(e.getMessage() + "\n");
            }
        }    
         
        
        scanner.close();
        duch.storageHandler.saveTasks();
        System.out.println("Bye. Hope to see you again");
    }
}
