package main.java;

import java.util.Arrays;

public class Solution_960 {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int longestIncSubstr = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (compare(strs, j, i) < 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            longestIncSubstr = Math.max(longestIncSubstr, dp[i]);
        }
        return n - longestIncSubstr;
    }

    private int compare(String[] strs, int i, int j) {
        for (String str : strs)
            if (str.charAt(i) > str.charAt(j)) return 1;
        return -1;
    }
}
