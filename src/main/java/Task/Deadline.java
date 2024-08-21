package Task;

public class Deadline extends Task {
    Date by;

    public Deadline(String name, String by, boolean done) {
        this(name, by);
        isDone = done;
    }

    public Deadline(String name, String by) {
        super(name);
        this.by = new Date(by);
    }

    public String toString() {
        return (isDone) ? "[D][X] " + task + " (by: " + by.toString() + ")" : "[D][ ] " + task + " (by: " + by.toString() + ")";
    }

    public String toStore() {
        return (isDone) ? "D|1|" + task + "|" + by.toStore() : "D|0|" + task + "|" + by.toStore();
    }


}
