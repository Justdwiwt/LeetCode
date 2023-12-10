package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        int num = 1;
        while (num * num <= n) {
            int k = num * num;
            IntStream.rangeClosed(1, n).filter(i -> i >= k).forEach(i -> dp[i] = Math.min(dp[i], dp[i - k] + 1));
            num += 1;
        }
        return dp[n];
    }
}
