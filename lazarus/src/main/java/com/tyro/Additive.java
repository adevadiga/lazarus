package com.tyro;

public class Additive {
    public static void main(String[] args) {
        String s = "pcmbz";
        System.out.println(countConsecutive(15));
        System.out.println(consecutive(15));
    }

    private final static double epsilon = 1E-10;

    static int countConsecutive(int N) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int) a == 0.0)
                count++;

        }
        return count;
    }

    public static int consecutive(long num) {
        int count = 0;
        for (int k = 1; k * (k + 1) < 2 * num; k++) {
            double result = (1.0 * num - (k * (k + 1)) / 2) / (k + 1);
            if (isNaturalNUmber(result)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNaturalNUmber(final double d) {
        return Math.abs(Math.floor(d) - d) < epsilon;
    }

}