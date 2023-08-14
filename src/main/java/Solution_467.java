package main.java;

import java.util.Arrays;

public class Solution_467 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] str = p.toCharArray();
        int cnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (i > 0 && (str[i] - 'a') == (str[i - 1] - 'a' + 1) % 26) cnt++;
            else cnt = 1;
            dp[str[i] - 'a'] = Math.max(cnt, dp[str[i] - 'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
