import java.util.Scanner;

public class Duch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        while (true) {
            String echo = scanner.nextLine();
            if (echo.equals("bye")) break;
            System.out.println(echo);
        }
        System.out.println("Bye. Hope to see you again");
    }
}
