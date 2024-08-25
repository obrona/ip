package Duch;

import org.junit.jupiter.api.Test;

import Duch.Task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    class TaskListStub extends TaskList {
        TaskListStub() {
            super();
        }
    }
    
    @Test
    public void testConcat() {
        Parser parser = new Parser(new TaskListStub());
        String[] arr = {"a1", "a2", "a3", "a4", "a5"};
        String expected = "a2 a3";
        assertEquals(expected, parser.concat(arr, 1, 3));
    }
}
