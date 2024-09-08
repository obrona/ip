package Duch.History;

import Duch.Task.Task;
import Duch.TaskList;

public class DeleteTaskHistory extends History {
    Task task;
    TaskList tasklist;
    int idx;

    public DeleteTaskHistory(TaskList tasklist, Task task, int idx) {
        this.task = task;
        this.tasklist = tasklist;
        this.idx = idx;
    }

    /**
     * Contains the code to undo the command
     */
    public void undo() {
        tasklist.add(idx, task);
    }


}
