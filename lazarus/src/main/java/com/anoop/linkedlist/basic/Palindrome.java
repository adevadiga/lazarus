package com.anoop.linkedlist.basic;

//Solution #1: Reverse and Compare
public class Palindrome {

    // Build a table of char and count. And check the map for max one odd letter
    // count

    static boolean isPalindrome(Node head) {
        Node reverse = reverseAndClone(head);
        return isEqual(head, reverse);
    }

    static Node reverseAndClone(Node head) {
        Node reverse = null;
        Node n = head;

        while (n != null) {
            Node t = new Node(n.data);
            t.next = reverse;
            reverse = t;

            n = n.next;
        }

        return reverse;
    }

    static boolean isEqual(Node one, Node two) {
        // You only need to look at half of list
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }

            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

}