import java.util.Scanner;



public class Duch {
    Printer printer = new Printer();
    CommandHandler commandHandler = new CommandHandler();

    public static void main(String[] args) {
        Duch duch = new Duch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("bye")) break;
            
            try {
                duch.commandHandler.handleCommand(text);
            } catch (Exception e) {
                duch.printer.print(e.getMessage());
            }
        }    
         
        
        scanner.close();
        System.out.println("Bye. Hope to see you again");
    }
}
