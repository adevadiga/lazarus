package com.anoop.linkedlist.basic;

import java.util.Stack;

//Solution #2: Iterative Approach
public class Palindrome2 {

    public static boolean test() {
        int[] elem = new int[] { 1, 2, 3, 3, 2, 1 };
        Node p1 = new Node(elem[0]);
        for (int i = 1; i < elem.length; i++) {
            p1.appendToTail(elem[i]);
        }
        System.out.println(p1);
        System.out.println("Is Palindrome: " + isPalindrome(p1));
        return true;
    }

    static boolean isPalindrome(Node head) {
        if (head == null)
            return false;

        Stack<Integer> stack = new Stack<Integer>();
        Node p1 = head;
        Node p2 = head;

        // Push till middle elements of list into stack. Using fast and slow runner
        // pointers
        while (p2 != null && p2.next != null) {
            System.out.println(p2.data);
            stack.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;

        }

        // odd number
        if (p2 != null) {
            p1 = p1.next;
        }

        System.out.println("Middle node: " + p1.data);
        System.out.println("Middle node+1: " + p1.next.data);
        System.out.println("Stack " + stack);
        // Now iterate through middle to end of list and see is the elements same as it
        // stack

        while (p1 != null) {
            int stacked = stack.pop();
            if (stacked != p1.data) {
                return false;
            }
            p1 = p1.next;
        }

        return true;
    }

}