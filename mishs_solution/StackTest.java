package com.interview.interview;

import com.interview.interview.model.exception.EmptyCollectionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack stack;

    private void pushFive(){
        for (int i=1;i<=5;i++) stack.push("thing "+i);
    }

    @Before
    public void runBeforeEveryTest() {
        stack = new Stack();
    }

    @Test
    public void isEmpty_returnsFalse(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_returnsFalse_afterCallingPush(){
        stack.push("thing");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void peek_returnsNull_whenEmpty(){
        assertNull(stack.peek());
    }

    @Test
    public void peek_returnsEntity_afterPush(){
        stack.push("thing");
        assertEquals("thing", stack.peek());
    }

    @Test(expected = EmptyCollectionException.class)
    public void pop_throwsEmptyStackException_whenEmpty(){
        stack.pop();
    }

    @Test
    public void pop_returnsEntity_afterPush(){
        stack.push("thing");
        assertEquals("thing", stack.pop());
    }

    @Test
    public void peek_returnsNull_afterPop(){
        stack.push("thing");
        stack.pop();
        assertNull(stack.peek());
    }

    @Test
    public void isEmpty_returnsTrue_afterPop(){
        stack.push("thing");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pop_returnsSecondItem_afterPushCalledTwice_thanPeek_returnsFirstItem(){
        stack.push("thing 1");
        stack.push("thing 2");
        assertEquals("thing 2", stack.pop());
        assertEquals("thing 1", stack.peek());
    }

    @Test
    public void contains_returnsTrue_whenEntityExists(){
        pushFive();
        assertTrue(stack.contains("thing 3"));
    }

    @Test
    public void contains_returnsFalse_whenEntityNotFound(){
        pushFive();
        assertFalse(stack.contains("thing -1"));
    }

    ////////////////
    ///  Bonus   ///
    ////////////////

    @Test
    public void size_returnsLength(){
        assertEquals(0, stack.size());
        pushFive();
        assertEquals(5, stack.size());
        stack.pop();
        assertEquals(4, stack.size());
    }

    @Test
    public void peekN_returnsNthValue(){
        pushFive();
        assertEquals("thing 3", stack.peekN(2));
    }

    @Test
    public void peekN_returnsNull_whenNoEntity(){
        assertNull(stack.peekN(1));
        pushFive();
        assertNull(stack.peekN(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void peekN_throwsIllegalArgumentException_whenGivenNegative(){
        stack.peekN(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void push_throwsIllegalArgumentException_whenGivenNull(){
        stack.push(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void contains_throwsIllegalArgumentException_whenGivenNull(){
        stack.contains(null);
    }

}
