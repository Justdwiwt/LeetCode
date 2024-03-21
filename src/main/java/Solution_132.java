package main.java;

public class Solution_132 {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        for (int right = 0; right < len; right++)
            for (int left = right; left >= 0; left--)
                dp[left][right] = right - left <= 1 && chs[left] == chs[right] || (chs[left] == chs[right] && dp[left + 1][right - 1]);
        int[] dp2 = new int[len];
        for (int right = 1; right < len; right++)
            if (!dp[0][right]) {
                dp2[right] = dp2[right - 1] + 1;
                for (int left = 0; left < right; left++)
                    if (dp[left][right]) dp2[right] = Math.min(dp2[right], dp2[left - 1] + 1);
            }
        return dp2[len - 1];
    }
}
