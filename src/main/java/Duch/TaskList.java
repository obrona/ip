package Duch;

import java.util.ArrayList;
import Duch.Task.Task;

/**
 * Stores a list of Tasks
 */
public class TaskList extends ArrayList<Task> {
    public TaskList() {
        super();
    }

    public void addTask(Task task) {
        super.add(task);
    }

    public void deleteTask(int idx) {
        super.remove(idx);
    }

    public void markTask(int idx) {
        super.get(idx).setDone(true);
    }

    public void unmarkTask(int idx) {
        super.get(idx).setDone(false);

    }
}
