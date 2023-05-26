package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_801 {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[][] dp = new int[2][len];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE));
        dp[0][0] = 0;
        dp[1][0] = 1;
        IntStream.range(1, A.length).forEach(i -> {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[0][i] = Math.min(dp[0][i], dp[0][i - 1]);
                dp[1][i] = Math.min(dp[1][i], dp[1][i - 1] + 1);
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[0][i] = Math.min(dp[0][i], dp[1][i - 1]);
                dp[1][i] = Math.min(dp[1][i], dp[0][i - 1] + 1);
            }
        });
        return Math.min(dp[0][len - 1], dp[1][len - 1]);
    }
}
