package main.java;

import java.util.stream.IntStream;

public class Solution_1000 {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if ((N - 1) % (K - 1) != 0) return -1;
        int[][] dp = new int[N][N];
        int[] sum = new int[N + 1];
        IntStream.range(0, N).forEach(i -> {
            dp[i][i] = stones[i];
            sum[i + 1] += sum[i] + stones[i];
        });
        for (int j = 1; j < N; j++)
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = dp[i][i] + dp[i + 1][j];
                for (int cut = i + K - 1; cut < j; cut += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][cut] + dp[cut + 1][j]);
                if ((j - i) % (K - 1) == 0) dp[i][j] += sum[j + 1] - sum[i];
            }
        return dp[0][N - 1] - sum[N];
    }
}
