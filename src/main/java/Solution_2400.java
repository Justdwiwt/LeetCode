package main.java;

public class Solution_2400 {
    public int numberOfWays(int startPos, int endPos, int k) {
        int MOD = 1000000007;
        int len = Math.abs(endPos - startPos) + 1;
        long[][] dp = new long[k + 1][k + 1];
        dp[0][0] = 1;
        for (int step = 1; step <= k; step++)
            for (int pos = 0; pos <= k; pos++) {
                if (pos != 0) {
                    dp[pos][step] += dp[pos - 1][step - 1];
                    dp[pos][step] += pos == k ? 0 : dp[pos + 1][step - 1];
                } else dp[pos][step] = 2 * dp[pos + 1][step - 1];
                dp[pos][step] %= MOD;
            }
        return len - 1 > k ? 0 : (int) dp[len - 1][k];
    }
}
