public class Ui {
    //String text;
    String space = "    ";
    
    // the text must be demarcated by \n
    // eg "line1\nline2\n" is valid, "line1\nline2" is invalid
    

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

    /*public static void main(String[] args) {
        new Printer("1. read book\n2. return book\n").print();
    }*/
}
