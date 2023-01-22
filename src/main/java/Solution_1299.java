package main.java;

public class Solution_1299 {
    public int[] replaceElements(int[] arr) {
        int[] dp = new int[arr.length];
        dp[dp.length - 1] = -1;
        for (int i = dp.length - 2; i >= 0; i--) dp[i] = Math.max(arr[i + 1], dp[i + 1]);
        return dp;
    }
}
