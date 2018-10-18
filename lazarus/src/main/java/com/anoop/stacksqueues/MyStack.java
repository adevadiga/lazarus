package com.anoop.stacksqueues;

public class MyStack<T> {

    public static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    // Unbounded stack
    public void push(T data) {
        StackNode<T> node = new StackNode<T>(data);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}