package com.anoop.linkedlist.basic;

public class LoopDetection {

    static Node findLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No loop. Fast always meets end
        if (fast == null || fast.next == null) {
            return null;
        }

        // Find the start point. slow & fast can be any node after loop start.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}