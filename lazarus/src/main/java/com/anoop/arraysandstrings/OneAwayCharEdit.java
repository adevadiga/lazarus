package com.anoop.arraysandstrings;

public class OneAwayCharEdit {

    /*
     * This is one of those problems where it's helpful to think about the "meaning"
     * of each of these operations. What does it mean for two strings to be one
     * insertion, replacement, or removal away from each other?
     * 
     * Replacement: Consider two strings, such as bale and pale, that are one
     * replacement away. Yes, that does mean that you could replace a character in
     * bale to make pale. But more precisely, it means that they are different only
     * in one place.
     * 
     * Insertion: The strings apple and aple are one insertion away. This means that
     * if you compared the strings, they would be identical-except for a shift at
     * some point in the strings.
     * 
     * Removal: The strings apple and aple are also one removal away, since removal
     * is just the inverse of insertion.
     */

    public static boolean check(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() == second.length() + 1) {
            return oneEditInsert(second, first);
        }

        return false;
    }

    static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check is inserting one char to s1 makes it s2 */
    static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    // public static boolean find(String s1, String s2) {
    // if (s1.equals(s2)) {
    // return true;// 0 insert
    // }
    // int diff = Math.abs(s1.length() - s2.length());
    // if (diff > 1) {
    // return false;// Cant adjust with 1 edit
    // }
    // // Make sure only 1 char is different. Insert,
    // // Check for insert only
    // char[] s1Content = s1.toCharArray();
    // char[] s2Content = s2.toCharArray();
    // char[] adjustedString = new char[Math.max(s1Content.length,
    // s2Content.length)];

    // if (s1Content.length > s2Content.length) {
    // copy(adjustedString, s1Content);
    // } else {
    // copy(adjustedString, s2Content);
    // }

    // for (int i = 0; i < s1Content.length; i++) {
    // int c1 = s1Content[i], c2 = s2Content[i];
    // if (c1 != c2) {
    // // insert to shorter array
    // insertToArray(adjustedString, i);
    // }
    // }

    // // return new String()
    // }

    // static void copy(char[] dest, char[] src) {
    // System.arraycopy(src, 0, dest, 0, src.length);
    // }

    // static void insertToArray(char[] dest, int pos, char ch) {
    // // Array has sufficient width. Just push the element
    // for (int i = dest.length - 2; i > pos; i--) {
    // dest[i + 1] = dest[i];
    // }
    // dest[pos] = ch;
    // }
}