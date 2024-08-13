package Task;

public class Deadline extends Task {
    String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public String toString() {
        return (isDone) ? "[D][X] " + task + " (by: " + by + ")" : "[D][ ] " + task + " (by: " + by + ")";
    }


}
