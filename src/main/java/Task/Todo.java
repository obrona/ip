package Task;

public class Todo extends Task {

    public Todo(String task, boolean done) {
        super(task, done);
    }
    
    public Todo(String task) {
        super(task);
    }

    public String toString() {
        return (isDone) ? "[T][X] " + task : "[T][ ] " + task;
    }

    public String toStore() {
        return (isDone) ? "T|1|" + task : "T|0|" + task;
    }

    
}
