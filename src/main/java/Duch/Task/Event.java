package Duch.Task;

public class Event extends Task {
    Date from;
    Date to;

    public Event(String task, String from, String to, boolean done) {
        this(task, from, to);
        isDone = done;
    }

    public Event(String task, String from, String to) {
        super(task);
        this.from = new Date(from);
        this.to = new Date(to);
    }

    public String toString() {
        return (isDone) ? "[E][X] " + task + " (from: " + from.toString() + " to: " + to.toString() + ")" 
                : "[E][ ] " + task + " (from: " + from.toString() + " to: " + to.toString() + ")";
    }

    public String toStore() {
        return (isDone) ? "E|1|" + task + "|" + from.toStore() + "|" + to.toStore() 
                : "E|0|" + task + "|" + from.toStore() + "|" + to.toStore();
    }

}
