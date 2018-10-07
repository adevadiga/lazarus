package com.anoop.linkedlist.basic;

public class DeleteMiddleNode {

    public void deleteAnyMiddleNode(Node n) {
        if (n == null || n.next == null) {
            return;
        }
        // Node next = n.next;
        n.data = n.next.data;
        n.next = n.next.next;
    }
}