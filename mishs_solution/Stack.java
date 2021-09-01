package com.interview.interview;

import com.interview.interview.model.exception.EmptyCollectionException;

public class Stack {

    private Node head;
    private long length = 0;

    public boolean isEmpty(){
        return head == null;
    }

    public void push(Object x){
        if(x == null) throw new IllegalArgumentException();
        head = new Node(x, head);
        length++;
    }

    public Object peek(){
        if(isEmpty()) return null;
        return head.data;
    }

    public Object pop(){
        if(isEmpty()) throw new EmptyCollectionException();
        Object ret = head.data;
        head = head.next;
        length--;
        return ret;
    }

    public boolean contains(Object x){
        if(x == null) throw new IllegalArgumentException();
        Node clone = head;
        while (clone != null){
            if (clone.data.equals(x)) return true;
            clone = clone.next;
        }
        return false;
    }

    public long size(){
        return length;
    }

    public Object peekN(long n){
        if(n>=length) return null;
        if(n<0) throw new IllegalArgumentException();
        Node clone = head;
        for (;n!=0;n--) clone = clone.next;
        return clone.data;
    }

    private static class Node{
        public Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

}
