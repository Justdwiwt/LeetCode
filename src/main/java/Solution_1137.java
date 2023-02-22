package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1137 {
    public int tribonacci(int n) {
        int[] dp = {0, 1, 1};
        if (n < 3) return dp[n];
        else {
            IntStream.rangeClosed(3, n).forEach(i -> dp[i % 3] = Arrays.stream(dp).sum());
            return dp[n % 3];
        }
    }
}
