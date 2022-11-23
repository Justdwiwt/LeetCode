package main.java;

import java.util.Arrays;

public class Solution_1542 {
    public int longestAwesome(String s) {
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int pre = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < 10; j++) {
                int target = 1 << j;
                max = Math.max(max, i - dp[target ^ pre]);
            }
            dp[pre] = Math.min(i, dp[pre]);
            max = Math.max(max, i - dp[pre]);
        }
        return max;
    }
}
