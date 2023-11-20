package main.java;

import java.util.Arrays;

public class Solution_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] pointers = new int[m];
        long[] dp = new long[n + 1];
        Arrays.fill(pointers, 1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) dp[i] = Math.min(dp[i], dp[pointers[j]] * primes[j]);
            for (int j = 0; j < m; j++) if (dp[i] == dp[pointers[j]] * primes[j]) pointers[j]++;
        }
        return (int) dp[n];
    }
}
