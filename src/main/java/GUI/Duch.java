package GUI;
import java.time.DateTimeException;
import java.util.Scanner;

import Duch.Parser;
import Duch.Storage;
import Duch.TaskList;
import Duch.Ui;




public class Duch {
    TaskList tasks = new TaskList();
    Ui ui = new Ui();
    Parser parser = new Parser(tasks);
    Storage storage = new Storage(tasks);

    public Duch() {
        storage.openFile();
    }

    public String getResponse(String cmd) {
        try {
            return parser.handleCommand(cmd);
        } catch (Exception e) {
            return e.getMessage();
        }
           
    }

    /**
     * Returns the welcome messgae
     * 
     * @return
     */
    public String getWelcomeString() {
        return "Hello I am Duch.\nWhat can I do for you?";
    }

    public void save() {
        storage.saveTasks();
    }
}
