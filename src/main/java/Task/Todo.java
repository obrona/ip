package Task;

public class Todo extends Task {
    
    public Todo(String task) {
        super(task);
    }

    public String toString() {
        return (isDone) ? "[T][X] " + task : "[T][ ] " + task;
    }

    
}
