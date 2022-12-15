package main.java;

import java.util.Arrays;

public class Solution_1449 {
    public String largestNumber(int[] cost, int target) {
        int n = cost.length;
        String[] dp = new String[target + 1];
        Arrays.fill(dp, "0");
        dp[0] = "";
        for (int i = n - 1; i >= 0; i--)
            for (int j = 1; j <= target; j++)
                if (j >= cost[i]) {
                    if (dp[j - cost[i]].equals("0"))
                        continue;
                    dp[j] = max(dp[j - cost[i]] + (i + 1), dp[j]);
                }
        return dp[target];
    }

    private String max(String s1, String s2) {
        if (s1.length() != s2.length()) return s1.length() > s2.length() ? s1 : s2;
        if (s1.compareTo(s2) >= 0) return s1;
        return s2;
    }
}
