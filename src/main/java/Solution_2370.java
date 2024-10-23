package main.java;

public class Solution_2370 {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int max = 0;
            for (int j = Math.max(index - k, 0); j <= (Math.min(index + k, 25)); j++) max = Math.max(dp[j], max);
            dp[index] = max + 1;
            res = Math.max(res, dp[index]);
        }
        return res;
    }
}
