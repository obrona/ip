import java.util.ArrayList;
import java.util.Scanner;



public class Duch {
    CommandHandler commandHandler = new CommandHandler();

    


    

    public static void main(String[] args) {
        Duch duch = new Duch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("bye")) break;
            duch.commandHandler.handleCommand(text);


        }
        scanner.close();
        System.out.println("Bye. Hope to see you again");
    }
}
