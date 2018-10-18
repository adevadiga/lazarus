package com.anoop.stacksqueues;

public class MyQueue<T> {

    public static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode<T> head;
    QueueNode<T> tail;

    // Add to end
    public void add(T data) {
        QueueNode<T> node = new QueueNode<T>(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;

        if (head == null) {
            head = tail;
        }
    }

    // Remove from head
    public T remove() {
        if (head == null) {
            throw new RuntimeException("Empty");
        }

        T item = head.data;
        head = head.next;

        // If head is NUll, there was only one Node and it was removed
        if (head == null) {
            tail = null;
        }

        return item;
    }
}