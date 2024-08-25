package Duch;

/**
 * Handles formatting text that needs to be printed on stdout
 */
public class Ui {
    String space = "    ";
    
    /**
     * Prettify the text and prints it to stdout.
     * The text must be demarcated by "\n" .
     * Eg "line1\nline2\n" is valid, "line1\nline2" is invalid.
     * 
     * @param text Text you want to print
     */
    public void print(String text) {
        System.out.println(space + "---------------------------------------------");
        int s = 0;
        int e = 0;
        while (e < text.length()) {
            if (text.charAt(e) =='\n') {
                e ++;
                System.out.print("    " + text.substring(s, e));
                s = e;
            } else {
                e ++;
            }
        }
        System.out.println(space + "---------------------------------------------\n");
    }
}
