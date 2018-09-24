package com.anoop.arraysandstrings;

/*String Rotation: Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
*/

public class StringRotation {

    public static boolean isRotate(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }

    public static boolean isSubString(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        boolean found = false;

        for (int i = 0; i <= len1 - len2; i++) {
            int j = 0;
            for (; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // Check whether we compared entire needle
            if (j == len2) {
                found = true;
            }

        }

        System.out.println("haystack: " + haystack + " needle: " + needle + " => " + found);
        return false;
        /*
         * char[] hay = haystack.toCharArray(); char[] nee = needle.toCharArray();
         * 
         * if (hay.length < nee.length) { return false; }
         * 
         * int index1 = 0; int index2 = 0;
         * 
         * while (index1 < hay.length && index2 < nee.length) { if (hay[index1] ==
         * nee[index2]) { index1++; index2++; } else { index1++; index2 = 0;// Reset
         * needle length back to 0 } } System.out.println(index2);
         * System.out.println("haystack: " + haystack + " needle: " + needle + " => " +
         * (index2 == nee.length)); return index2 == nee.length;
         */
    }
}