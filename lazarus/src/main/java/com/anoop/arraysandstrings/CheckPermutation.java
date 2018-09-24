package com.anoop.arraysandstrings;

/*
 *Check if one string is permutation of other
 */
public class CheckPermutation {

    // Do a sort and compare
    static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static boolean checkIsBothArePermute(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    /**************************************** */

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letters = new int[128];
        char[] s1Letters = s1.toCharArray();
        char[] s2Letters = s2.toCharArray();

        for (char c : s1Letters) {
            letters[c]++;
        }

        for (int i = 0; i < s2Letters.length; i++) {
            int c = s2Letters[i];
            letters[c]--;

            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
