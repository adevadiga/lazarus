package com.anoop.learning;

public class AllFib {

    static void run(int n) {
        int[] mem = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " => " + fib(i, mem));
        }
    }

    static int fib(int n, int[] mem) {
        if (n <= 1)
            return 0;
        else if (n == 2)
            return 1;
        else if (mem[n] > 0)
            return mem[n];

        mem[n] = fib(n - 1, mem) + fib(n - 2, mem);
        return mem[n];
    }

    public static void main(String[] args) {
        run(10);
    }
}