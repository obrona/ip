package Task;

public abstract class Task {
    String task;
    boolean isDone;

    public Task(String task) {
        this.task = task;
        isDone = false;
    }

    public void setDone(boolean val) {
        isDone = val;
    }

    public abstract String toString();
}
