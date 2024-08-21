package Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// dates inputted must be in the format d/MM/yyyy HHmm
public class Date {
    LocalDateTime dateTime;
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm");
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy HHmm");

    public Date(String str) {
        dateTime = LocalDateTime.parse(str, inputFormatter);
    }

    public String toString() {
        return dateTime.format(outputFormatter);
    }

    // when storing, print the date in the input format, so the constructor can parse it properly
    public String toStore() {
        return dateTime.format(inputFormatter);
    }

    public static void main(String[] args) {
        String d = "Dec-02-2009 1800";
        try {
            System.out.println(new Date(d).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(new Date(d).toString());
    }
}
