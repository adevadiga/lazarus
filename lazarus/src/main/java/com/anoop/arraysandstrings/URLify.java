package com.anoop.arraysandstrings;

/*
* Basic idea is to count how many space char are there and reserve that much space in array. 
* Then go over character from last index
*/
public class URLify {
    static final String SPACE = "%20";

    public static String replaceChars(String s, int trueLength) {
        char[] str = s.toCharArray();
        int spaceCount = 0;
        // count space
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        int index = trueLength + spaceCount * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '%';
                str[index - 2] = '2';
                str[index - 3] = '0';

                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        return new String(str);
    }
}
