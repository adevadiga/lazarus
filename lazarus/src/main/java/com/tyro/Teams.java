package com.tyro;

public class Teams {
    public static void main(String[] args) {
        String s = "pcmbz";
        System.out.println(differentTeams(s));
    }

    /*
     * Complete the function below.
     */
    static int differentTeams(String skills) {
        if (skills == null || skills.isEmpty()) {
            return 0;
        }

        int[] table = buildSubjectFrequency(skills);
        return checkMaxTeam(table);
    }

    static int[] buildSubjectFrequency(String skills) {
        int[] subjectsTable = new int[5];// p,c,m,b,z
        char[] skillsCode = skills.toCharArray();
        for (char ch : skillsCode) {
            int val = getCharNumber(ch);
            if (val != -1) {
                subjectsTable[val]++;
            }
        }
        return subjectsTable;
    }

    static int checkMaxTeam(int[] table) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < table.length; i++) {
            if (table[i] < minValue) {
                minValue = table[i];
            }
        }

        return minValue == Integer.MAX_VALUE ? 0 : minValue;
    }

    static int getCharNumber(char ch) {

        switch (ch) {
        case 'p':
            return 0;
        case 'c':
            return 1;
        case 'm':
            return 2;
        case 'b':
            return 3;
        case 'z':
            return 4;
        default:
            return -1;
        }

        // Add validaton for only following chars. p,c,m,b,z
        /*
         * int a = Character.getNumericValue('a'); int z =
         * Character.getNumericValue('z'); int val = Character.getNumericValue(ch);
         * 
         * if (val >= a || val <= z) { return val - a; } return -1;
         */
    }

}