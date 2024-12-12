package main.java;

import java.util.Arrays;

public class Solution_2430 {
    public int deleteString(String s) {
        int len = s.length(), max = 0;
        int[][] dps = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--)
            for (int j = len - 1; j > i; j--)
                if (s.charAt(i) == s.charAt(j)) dps[i][j] = dps[i + 1][j + 1] + 1;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= Math.max(i - (len - i), 0); j--)
                if (dps[j][i] >= i - j && dp[j] >= 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return max + 1;
    }
}
