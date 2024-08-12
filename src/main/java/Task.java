public class Task {
    String task;
    boolean isDone;

    Task(String task) {
        this.task = task;
        isDone = false;
    }

    public void setDone(boolean val) {
        isDone = val;
    }

    
    
    @Override
    public String toString() {
        String begin = (isDone) ? "[X] " : "[ ] ";
        return begin + task;
    }
}
