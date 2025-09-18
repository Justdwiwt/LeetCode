package main.java;

public class Solution_2827 {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return numberOfBeautifulIntegers(high + 1, k) - numberOfBeautifulIntegers(low, k);
    }

    private int numberOfBeautifulIntegers(int n, int k) {
        char[] chs = String.valueOf(n).toCharArray();
        int len = chs.length, c = 1, m = 0;
        int[][][] dp = new int[len][k][len * 2 + 1];
        dp[0][0][len] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                int t = (j * c) % k, f = (j & 1) == 0 ? 1 : -1;
                for (int q = 0; q < k; q++) {
                    int[] media = dp[i - 1][(q - t + k) % k];
                    for (int p = 0; p < media.length; p++) {
                        if (p - f < 0 || p - f >= media.length) continue;
                        dp[i][q][p] += media[p - f];
                    }
                }
            }
            c *= 10;
        }
        int f = 0;
        c = 1;
        for (int i = 1; i < len; i++) {
            if ((i & 1) == 0) {
                for (int j = 1; j < 10; j++) {
                    int f_ = (j & 1) == 0 ? 1 : -1, t = (j * c) % k;
                    m += dp[i - 1][(k - t) % k][len - f_];
                }
            }
            c *= 10;
        }
        if ((len & 1) == 1) return m;
        c = (int) Math.pow(10, len);
        for (int i = 0; i < len; i++) {
            int t = chs[i] - '0', q = n / c * c;
            for (int j = (i == 0 ? 1 : 0); j < t; j++) {
                int f_ = (j & 1) == 0 ? 1 : -1, p = (q + j * c / 10) % k;
                m += dp[len - i - 1][(k - p) % k][len - f_ - f];
            }
            f += ((t & 1) == 0 ? 1 : -1);
            c /= 10;
        }
        return m;
    }
}
