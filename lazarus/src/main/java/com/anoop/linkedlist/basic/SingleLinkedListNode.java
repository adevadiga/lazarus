package com.anoop.linkedlist.basic;

public class SingleLinkedListNode {
    SingleLinkedListNode next = null;
    int data;

    SingleLinkedListNode(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        SingleLinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }

        SingleLinkedListNode end = new SingleLinkedListNode(data);
        n.next = end;
    }

}