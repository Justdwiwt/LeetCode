package main.java;

import java.util.Arrays;

public class Solution_2719 {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int len = num1.length(), len1 = num2.length();
        long[][] dp = new long[len1 + 1][max_sum + 1];
        long m = 0;
        int f = 0, mod = (int) 1e9 + 7;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= len1; i++)
            for (int j = 0; j <= max_sum; j++)
                for (int k = 0; k <= Math.min(j, 9); k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
        for (int i = 0; i < len1; i++) {
            int c = num2.charAt(i) - '0';
            for (int j = 0; j < c; j++) {
                int r = max_sum - j - f, l = min_sum - j - f;
                if (r < 0) break;
                m += dp[len1 - i - 1][r] - (l - 1 < 0 ? 0 : dp[len1 - i - 1][l - 1]);
                m %= mod;
            }
            f += c;
        }
        if (f <= max_sum && f >= min_sum) m++;
        f = 0;
        for (int i = 0; i < len; i++) {
            int c = num1.charAt(i) - '0';
            for (int j = 0; j < c; j++) {
                int r = max_sum - j - f, l = min_sum - j - f;
                if (r < 0) break;
                m -= dp[len - i - 1][r] - (l - 1 < 0 ? 0 : dp[len - i - 1][l - 1]);
                if (m < 0) m += mod;
            }
            f += c;
        }
        return (int) m;
    }
}
