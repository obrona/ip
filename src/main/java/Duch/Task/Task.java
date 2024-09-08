package Duch.Task;

public abstract class Task {
    String task;
    boolean isDone;

    public Task(String task, boolean done) {
        this.task = task;
        isDone = done;
    }

    public Task(String task) {
        this.task = task;
        isDone = false;
    }
    
    public void setDone(boolean val) {
        isDone = val;
    }

    public String getTask() {
        return task;
    }

    public abstract String toString();

    public abstract String toStore();
}
