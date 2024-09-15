package duch.task;

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

    public boolean getIsDone() {
        return isDone;
    }

    public abstract String toString();

    public abstract String toStore();

    /**
     * Returns a clone of the object, for keeping track of history when undoing.
     */
    public abstract Task clone();
}
