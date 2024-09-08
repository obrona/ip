package Duch.History;

import Duch.Task.Task;

public class UnmarkHistory extends History {
    Task task;
    
    public UnmarkHistory(Task task) {
        this.task = task;
    }

    /**
     * Contains the code to undo the command
     */
    public void undo() {
        task.setDone(true);
    }
}
