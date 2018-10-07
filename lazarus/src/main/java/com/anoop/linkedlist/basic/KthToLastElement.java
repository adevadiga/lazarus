
package com.anoop.linkedlist.basic;

//Implement an algorithm to find the kth to last element of a singly linked list.

public class KthToLastElement {

    public int printKthToLast(Node head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println("Found: " + head.data);
        }
        return index;
    }

    public Node iter(Node head, int k) {
        Node p1 = head, p2 = head;

        // Move p1 k step ahead
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        // Once p1 is fixed & p2 is still head, now p2
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;

    }

}