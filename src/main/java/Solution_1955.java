package main.java;

import java.util.Arrays;

public class Solution_1955 {
    public int countSpecialSubsequences(int[] nums) {
        final int M = 1000000007;
        int[] dp = new int[]{1, 0, 0, 0};
        Arrays.stream(nums).forEach(n -> dp[n + 1] = (dp[n] + 2 * dp[n + 1] % M) % M);
        return dp[3];
    }
}
