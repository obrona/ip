package Task;

public class Deadline extends Task {
    String by;

    public Deadline(String name, String by, boolean done) {
        super(name, done);
        this.by = by;
    }

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public String toString() {
        return (isDone) ? "[D][X] " + task + " (by: " + by + ")" : "[D][ ] " + task + " (by: " + by + ")";
    }

    public String toStore() {
        return (isDone) ? "D|1|" + task + "|" + by : "D|0|" + task + "|" + by;
    }


}
