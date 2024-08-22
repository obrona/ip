import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import Task.*;



public class Storage {
   TaskList tasks;
    String pathString = "../data/tasks";

    public Storage(TaskList lst) {
        tasks = lst;
    }

    public void parseTodo(String str) {
        // "|" is one of the special expressions in regex, so need \\
        String[] splitted = str.split("\\|");
        tasks.add(new Todo(splitted[2], splitted[1].equals("1")));
    }

    public void parseDeadline(String str) {
        String[] splitted = str.split("\\|");
        tasks.add(new Deadline(splitted[2], splitted[3], splitted[1].equals("1")));
    }

    public void parseEvent(String str) {
        String[] splitted = str.split("\\|");
        tasks.add(new Event(splitted[2], splitted[3], splitted[4], splitted[1].equals("1")));
    }

    public void openFile() {
        Path path = Paths.get(pathString);
        Path directory = path.getParent();
        try {
            if (Files.notExists(directory)) {
                Files.createDirectories(directory);
            }

            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {System.out.println(e.getMessage());}
        
        // start reading from file
        try {
            Scanner scanner = new Scanner(Files.newBufferedReader(path));
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.length() == 0) break;
                
                char type = str.charAt(0);
                if (type == 'T') parseTodo(str);
                else if (type == 'E') parseEvent(str);
                else if (type == 'D') parseDeadline(str);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    // only call this after calling openFile, because I assume ../../../data/tasks is created already
    // the relative file path is relative to the path of the compiled class files, so if compiled class files 
    // are somewhere else, good luck
    public void saveTasks() {
        Path path = Paths.get(pathString);
        try {
            // clear existing contents
            Files.write(path, "".getBytes());
            for (Task task : tasks) {
                Files.write(path, (task.toStore() + "\n").getBytes(), StandardOpenOption.APPEND);
            }
        } catch(IOException e) {System.out.println(e.getMessage());}

    }
}
