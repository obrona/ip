package Task;

public class Event extends Task {
    public String from;
    public String to;

    public Event(String task, String from, String to, boolean done) {
        super(task, done);
        this.from = from;
        this.to = to;
    }

    public Event(String task, String from, String to) {
        super(task);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return (isDone) ? "[E][X] " + task + " (from: " + from + " to: " + to + ")" 
            : "[E][ ] " + task + " (from: " + from + " to: " + to + ")";
    }

    public String toStore() {
        return (isDone) ? "E|1|" + task + "|" + from + "|" + to : "E|0|" + task + "|" + from + "|" + to;
    }

}
