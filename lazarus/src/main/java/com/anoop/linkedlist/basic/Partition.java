package com.anoop.linkedlist.basic;

/*
Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
*/
public class Partition {
    public static void testMe() {
        int[] elem = new int[] { 3, 5, 8, 5, 10, 2, 1 };
        Node head = new Node(elem[0]);
        for (int i = 1; i < elem.length; i++) {
            head.appendToTail(elem[i]);
        }

        System.out.println(head);
        Node partiationedHead = partiton(head, new Node(5));
        System.out.println(partiationedHead);
    }

    public static Node partiton(Node head, Node pivot) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        Node n = head;
        while (n != null) {
            Node next = n.next;
            n.next = null;// Make the node as individual one. Save pointer separately
            if (n.data < pivot.data) {
                if (beforeStart == null) {
                    beforeStart = n;
                    beforeEnd = n;
                } else {
                    beforeEnd.next = n;
                    beforeEnd = n;
                }
            } else {
                if (afterStart == null) {
                    afterStart = n;
                    afterEnd = n;
                } else {
                    afterEnd.next = n;
                    afterEnd = n;
                }
            }

            n = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        // Merge
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public Node elegant(Node node, Node pivot) {
        Node head = node;
        Node tail = node;
        while (node != null) {
            Node next = node.next;
            if (node.data < pivot.data) {
                node.next = head;
                head = node;
            } else {
                node.next = tail;
                tail = node;
            }

            node = next;
        }
        return head;
    }
}