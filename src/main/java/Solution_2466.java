package main.java;

public class Solution_2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int M = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i - zero] + dp[i]) % M;
            if (i >= one) dp[i] = (dp[i - one] + dp[i]) % M;
            if (i >= low) res = (res + dp[i]) % M;
        }
        return res;
    }
}
