package com.anoop.linkedlist.basic;

class Node {
    Node next = null;
    int data;

    Node(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }

        Node end = new Node(data);
        n.next = end;
    }

    public String toString() {
        Node n = this;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.data).append(" -> ");
            n = n.next;
        }
        return sb.toString();
    }
}

// Singly linked list. Delete node
public class DeleteNode {

    public Node delete(Node head, int d) {
        if (head.data == d) {
            return head.next;
        }

        Node n = head;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }
}