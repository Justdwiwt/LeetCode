package main.java;

public class Solution_2787 {
    public static int MOD = (int) Math.pow(10, 9) + 7;

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int v = (int) Math.pow(i, x);
            for (int j = n; j >= v; j--) {
                dp[j] += dp[j - v];
                dp[j] = (int) (dp[j] % MOD);
            }
        }
        return (int) dp[n];
    }
}
