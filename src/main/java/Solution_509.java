package main.java;

import java.util.stream.IntStream;

public class Solution_509 {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        IntStream.rangeClosed(2, n).forEach(index -> dp[index] = dp[index - 1] + dp[index - 2]);
        return dp[n];
    }
}
