package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length(), m = original.length;
        int[][] dp = new int[26][26];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        IntStream.range(0, 26).forEach(i -> dp[i][i] = 0);
        IntStream.range(0, m).forEach(i -> {
            int x = original[i] - 'a', y = changed[i] - 'a';
            dp[x][y] = Math.min(dp[x][y], cost[i]);
        });
        for (int k = 0; k < 26; k++)
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = source.charAt(i) - 'a', y = target.charAt(i) - 'a';
            if (dp[x][y] == Integer.MAX_VALUE) return -1;
            ans += dp[x][y];
        }
        return ans;
    }
}
