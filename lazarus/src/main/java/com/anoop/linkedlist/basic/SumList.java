package com.anoop.linkedlist.basic;

public class SumList {

    public static void sumIt() {
        int[] elem = new int[] { 7, 1, 6 };
        Node p1 = new Node(elem[0]);
        for (int i = 1; i < elem.length; i++) {
            p1.appendToTail(elem[i]);
        }
        System.out.println(p1);

        elem = new int[] { 5, 9, 9 };
        Node p2 = new Node(elem[0]);
        for (int i = 1; i < elem.length; i++) {
            p2.appendToTail(elem[i]);
        }
        System.out.println(p2);

        Node result = sum(p1, p2, 0);
        System.out.println(result);
    }

    static Node sum(Node p1, Node p2, int carry) {

        if (p1 == null && p2 == null && carry == 0) {
            return null;
        }
        Node result = new Node(0);
        int value = carry;
        if (p1 != null) {
            value += p1.data;
        }
        if (p2 != null) {
            value += p2.data;
        }

        result.data = value % 10;

        if (p1 != null || p2 != null) {
            Node more = sum(p1 == null ? null : p1.next, p2 == null ? null : p2.next, value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
}