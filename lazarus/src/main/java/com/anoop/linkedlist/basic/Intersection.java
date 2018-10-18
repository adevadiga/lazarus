package com.anoop.linkedlist.basic;

/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
pg95
*/
class Result {
    Node tail;
    int size;

    public Result(Node node, int size) {
        this.tail = node;
        this.size = size;
    }
}

public class Intersection {

    static Node find(Node p1, Node p2) {
        if (p1 == null || p2 == null)
            return null;

        Result result1 = getTailAndSize(p1);
        Result result2 = getTailAndSize(p2);

        // Should have same tail node
        if (result1.tail != result2.tail)
            return null;

        /* Set pointers to the start of each linked list. */
        Node shorterList = result1.size > result2.size ? p2 : p1;
        Node longerList = result1.size > result2.size ? p1 : p2;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longerList = getKthNode(longerList, Math.abs(result1.size - result2.size));

        while (longerList != shorterList) {
            shorterList = shorterList.next;
            longerList = longerList.next;
        }

        return longerList;// Node

    }

    static Result getTailAndSize(Node head) {
        if (head == null)
            return null;

        int size = 1;
        Node current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }

        return new Result(current, size);
    }

    static Node getKthNode(Node node, int k) {
        Node current = node;
        while (k > 0 && current != null) {
            k--;
            current = current.next;
        }
        return current;
    }

    // Reach
    static void attempt1(Node p1, Node p2) {

        Node n1 = p1, n2 = p2;

        while (n1.next != null && n2.next != null) {
            if (n1 == n2) {
                System.out.println("Found!!!");
                break;
            }
            if (n1.next == null) {
                n1 = p1;
            }

            if (n2.next == null) {
                n2 = p2;
            }
        }

    }
}
