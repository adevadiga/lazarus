package com.anoop.arraysandstrings;

public class StringCompression {

    // The better one.
    static String compress2(String s) {
        // Can pre-compute final length of compressed string to avoid new StringBuilder
        // creation and giving an inital capcity to StringBuilder
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            // If its end-of string or next char is diff
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressed.append(s.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < s.length() ? compressed.toString() : s;
    }

    public static void compress(String s) {
        char[] contents = s.toCharArray();
        StringBuilder compressesd = new StringBuilder();

        for (int i = 0; i < contents.length;) {
            compressesd.append(contents[i]);
            int count = 1;
            int j = i + 1;
            while (j < contents.length && contents[i] == contents[j]) {
                count++;
                j++;
            }
            compressesd.append(count);

            i += count;
        }

        if (compressesd.length() >= s.length()) {
            System.out.println(s);
        } else {
            System.out.println(compressesd.toString());
        }
    }
}