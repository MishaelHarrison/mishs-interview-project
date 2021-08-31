package com.interview.interview;

import org.junit.Before;

public class StackTest {

    private Stack stack;

    @Before
    public void runBeforeEveryTest() {
        stack = new Stack();
    }

    @Test
    public void isEmpty_ReturnsTrue_IfStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }


}
