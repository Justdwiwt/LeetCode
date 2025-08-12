package main.java;

import java.util.Arrays;

public class Solution_2767 {
    private boolean check(int num) {
        while (num >= 5 && num % 5 == 0) num /= 5;
        return num == 1;
    }

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = i; j >= 1; j--) {
                String sub = String.valueOf(chars, j - 1, i - j + 1);
                if (chars[j - 1] == '0' || !check(Integer.parseInt(sub, 2))) continue;
                dp[i] = Math.min(dp[i], dp[j - 1] + 1);
            }
        return dp[n] >= n + 1 ? -1 : dp[n];
    }
}
