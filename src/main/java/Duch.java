import java.util.ArrayList;
import java.util.Scanner;

public class Duch {
    static Printer p = new Printer();
    public static void main(String[] args) {
        ArrayList<String> texts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I am Duch.\nWhat can I do for you?");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("bye")) {
                break;
            } else if (text.equals("list")) {
                String str = "";
                for (int i = 0; i < texts.size(); i ++) {
                    str += (i + 1) + ": " + texts.get(i) + "\n";
                }
                p.print(str);
            } else {
                texts.add(text);
                p.print("added: " + text + '\n');
            }
        }
        scanner.close();
        System.out.println("Bye. Hope to see you again");
    }
}
