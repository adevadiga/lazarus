package com.anoop.linkedlist.basic;

import java.util.HashSet;
import java.util.Set;

/*
* Write code to remove duplicates from an unsorted linked list.
*/
public class RemoveDuplicates {

    /*
     * O(n) time
     */
    public static void remove(Node head) {
        Node n = head;
        Set<Integer> set = new HashSet<Integer>();
        Node prev = null;
        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }

            n = n.next;
        }
    }

    /*
     * No buffer allowed. But O(n2)
     */
    public static void remove2(Node head) {
        Node current = head;

        while (current != null) {
            /* Remove all future nodes that have the same value */
            Node runner = current;// Note here. runner also starts from current

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}