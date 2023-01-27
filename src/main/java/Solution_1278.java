package main.java;

import java.util.stream.IntStream;

public class Solution_1278 {
    public int palindromePartition(String s, int k) {
        int len = s.length();
        int[][] dp = new int[k + 1][len + 1];
        IntStream.rangeClosed(1, len).forEach(i -> dp[1][i] = modify(s, 0, i - 1));
        for (int m = 2; m <= k; m++)
            for (int i = m; i <= len; i++) {
                dp[m][i] = len + 1;
                for (int j = m - 1; j < i; j++)
                    dp[m][i] = Math.min(dp[m][i], dp[m - 1][j] + modify(s, j, i - 1));
            }
        return dp[k][len];
    }

    private int modify(String s, int start, int end) {
        int change = 0;
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--)) change++;
        return change;
    }
}
