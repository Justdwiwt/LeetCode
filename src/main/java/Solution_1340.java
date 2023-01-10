package main.java;

public class Solution_1340 {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++)
            res = Math.max(res, jump(arr, d, i, dp));
        return res;
    }

    private int jump(int[] arr, int d, int idx, int[] dp) {
        if (dp[idx] != 0) return dp[idx];
        dp[idx] = 1;
        for (int i = 1; i <= d && idx >= i && arr[idx - i] < arr[idx]; i++)
            dp[idx] = Math.max(dp[idx], jump(arr, d, idx - i, dp) + 1);
        for (int i = 1; i <= d && idx + i < arr.length && arr[idx + i] < arr[idx]; i++)
            dp[idx] = Math.max(dp[idx], jump(arr, d, idx + i, dp) + 1);
        return dp[idx];
    }
}
