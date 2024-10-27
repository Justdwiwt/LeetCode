package main.java;

import java.util.stream.IntStream;

public class Solution_2376 {
    public int countSpecialNumbers(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        int len = chs.length, m = 9, f = 0;
        if (len == 1) return n;
        int[] dp = new int[len];
        dp[0] = 1;
        IntStream.range(1, len).forEach(i -> dp[i] = (10 - len + i) * dp[i - 1]);
        int c = 10, c0 = 9;
        for (int i = 1; i < len - 1; i++) {
            m += c * (10 - i) - c0;
            c *= (10 - i);
            c0 *= (9 - i);
        }
        for (int i = 0; i < len; i++) {
            int t = chs[i] - '0', k = 0;
            for (int j = 0; j < t; j++) if ((f & (1 << j)) == 0) k++;
            if (i == 0) k--;
            m += (dp[len - i - 1] * k);
            if ((f & (1 << t)) != 0) return m;
            f |= (1 << t);
        }
        return m + 1;
    }
}
