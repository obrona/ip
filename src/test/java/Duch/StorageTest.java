package duch;

import org.junit.jupiter.api.Test;

import duch.task.Task;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class StorageTest {
    class TaskListStub extends TaskList {
        TaskListStub() {
            super();
        }
    }
    
    @Test
    public void testParseTodoFromStorage() {
        TaskListStub taskListStub = new TaskListStub();
        Storage storage = new Storage(taskListStub);
        String testString = "T|0|homework";
        storage.parseTodo(testString);
        Task todo = taskListStub.get(0);
        String output = "[T][ ] homework";
        assertEquals(output, todo.toString());
    }

    @Test
    public void testParseDeadlineFromStorage() {
        TaskListStub taskListStub = new TaskListStub();
        Storage storage = new Storage(taskListStub);
        String testString = "D|0|hw|12/01/2002 1800";
        storage.parseDeadline(testString);
        Task deadline = taskListStub.get(0);
        String output = "[D][ ] hw (by: Jan-12-2002 1800)";
        assertEquals(output, deadline.toString());
    }

    @Test
    public void testParseEventFromStorage() {
        TaskListStub taskListStub = new TaskListStub();
        Storage storage = new Storage(taskListStub);
        String testString = "E|1|hw|12/01/2002 1800|12/02/2002 1800";
        storage.parseEvent(testString);
        Task event = taskListStub.get(0);
        String output = "[E][X] hw (from: Jan-12-2002 1800 to: Feb-12-2002 1800)";
        assertEquals(output, event.toString());
    }
}
