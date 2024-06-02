package main.java;

import java.util.stream.IntStream;

public class Solution_70 {
    public int climbStairs(int n) {
        int[] dp = {1, 2};
        IntStream.range(2, n).forEach(i -> dp[i & 1] = dp[0] + dp[1]);
        return dp[(n - 1) & 1];
    }
}
