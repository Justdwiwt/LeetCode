package main.java;

import java.util.Arrays;

public class Solution_2801 {
    public int countSteppingNumbers(String low, String high) {
        int mod = (int) 1e9 + 7;
        int lenL = low.length(), lenH = high.length();
        long l = lenL > 1 ? 10 : 1, h = lenH > 1 ? 10 : 1;
        long[][] dp = new long[lenH + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= lenH; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = j == 9 ? dp[i - 1][8] : (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                if (i < lenL) l = (l + dp[i][j]) % mod;
                if (i < lenH) h = (h + dp[i][j]) % mod;
            }
        }
        h = countSteppingNumbers(high, dp, h, 1);
        l = countSteppingNumbers(low, dp, l, 0);
        return (int) (h - l < 0 ? h - l + mod : h - l);
    }

    private long countSteppingNumbers(String num, long[][] dp, long m, int p) {
        int len = num.length(), mod = (int) 1e9 + 7, f = num.charAt(0) - '0';
        for (int j = 1; j < f; j++) m = (m + dp[len][j]) % mod;
        for (int i = 1; i < len; i++) {
            int t = num.charAt(i) - '0';
            if (f - 1 >= 0 && f - 1 < t) m = (m + dp[len - i][f - 1]) % mod;
            if (f + 1 < t) m = (m + dp[len - i][f + 1]) % mod;
            if (Math.abs(f - t) != 1) return (int) m;
            f = t;
        }
        return (int) (m + p) % mod;
    }
}
