package main.java;

public class Solution_2585 {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = (int) 1e9 + 7;
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int[] type : types)
            for (int j = target; j >= 0; j--) {
                for (int k = 1; k <= type[0]; k++) {
                    int t = k * type[1];
                    if (t > j) break;
                    if (dp[j - t] <= 0) continue;
                    dp[j] = (dp[j] + dp[j - t]) % mod;
                }
            }
        return (int) dp[target];
    }
}
