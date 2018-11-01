package com.anoop;

public class CountWays {

  static void count(int n) {
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    
    countWays(n, memo);
  }
  
  static int countWays(int n, int[] memo) {
      if (n < 0) {
        return 0;
      } else if (n == 0) {
        return 1;
      } else if (mem[n] > -1) {
        return mem[n];
      } else {
      
        mem[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
        return mem[n];
      }
   }

}
