package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2463 {
    static long INF = Long.MAX_VALUE / 2;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int m = factory.length;
        int n = robot.size();
        long[][] dp = new long[m + 1][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, INF));
        IntStream.rangeClosed(0, m).forEach(i -> dp[i][0] = 0);
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                long cost = 0;
                for (int k = 1; k <= factory[i - 1][1] && j - k >= 0; k++) {
                    cost += Math.abs(factory[i - 1][0] - robot.get(j - k));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + cost);
                }
            }
        return dp[m][n];
    }
}
