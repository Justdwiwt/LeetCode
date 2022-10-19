package main.java;

import java.util.stream.IntStream;

public class Solution_1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] pre = new int[n + 1];
        IntStream.range(0, n).forEach(i -> pre[i + 1] = pre[i] + stones[i]);
        return dfs(0, n - 1, pre, dp);
    }

    private int dfs(int l, int r, int[] pre, int[][] dp) {
        if (l == r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        return dp[l][r] = Math.max(pre[r + 1] - pre[l + 1] - dfs(l + 1, r, pre, dp), pre[r] - pre[l] - dfs(l, r - 1, pre, dp));
    }
}
