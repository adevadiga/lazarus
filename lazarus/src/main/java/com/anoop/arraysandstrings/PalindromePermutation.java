package com.anoop.arraysandstrings;

public class PalindromePermutation {

    // Algo: There can't be more than one odd char in the string for both even & odd
    // numbered string.
    // If string has even number of character then it can't have one odd :)
    public static boolean check(String s) {
        int[] table = buildCharFrequency(s);
        return checkMaxOneOdd(table);
    }

    static boolean checkMaxOneOdd(int[] table) {
        for (int count : table) {
            boolean oddFound = false;
            if (count % 2 == 1) {
                if (oddFound) {
                    return false; // More than one odd found.
                }
                oddFound = true;
            }
        }
        return true;
    }

    // Can we optimize storage instead using array of 128 chars.
    // Like map a-> 0 b-> 1 and so on
    static int[] buildCharFrequency(String s) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : s.toCharArray()) {
            int val = getCharNumber(c);
            if (val != -1) {
                table[val]++;
            }
        }
        return table;
    }

    static int getCharNumber(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);

        if (val >= a || val <= z) {
            return val - a;
        }
        return -1;
    }

    // Wrong. It should have even count of all letters except one in case of odd
    // numberof chars

}