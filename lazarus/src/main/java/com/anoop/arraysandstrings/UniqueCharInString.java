package com.anoop.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *Check if string has all unique characters
 */
public class UniqueCharInString {

    // O(n), specifically it won't iterate more than 128(character set) times.
    // O(c) -> c - char set size
    public static boolean isUnique(String s) {
        // Asscume ascci and max char set contains 128 char. So has to repeat if string
        // has more than 128 chars
        if (s.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    // O(n^2)
    public static boolean isUnique_Take1(String s) {
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length - 1; i++) {
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[i] == letters[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n) & using space O(n) - use Map or using count[] array
    public static boolean isUnique_Take2(String s) {
        char[] letters = s.toCharArray();
        int[] count = new int[256];// increment index
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : letters) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }

        return true;
    }

    // Sort array & go through subsequent element. O(nlogn)
    public static boolean isUnique_Take3(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == letters[i + 1]) {
                return false;
            }
        }
        return true;
    }
}