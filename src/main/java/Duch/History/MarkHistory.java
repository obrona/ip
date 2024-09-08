package Duch.History;

import Duch.Task.Task;

public class MarkHistory extends History {
    private Task task;
    
    public MarkHistory(Task task) {
        this.task = task;
    }

    /**
     * Contains the code to undo the command
     */
    public void undo() {
        task.setDone(false);
    }

}
