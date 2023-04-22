package main.java;

import java.util.stream.IntStream;

public class Solution_903 {
    public int numPermsDISequence(String s) {
        int len = s.length();
        int M = (int) 1e9 + 7;
        int[] dp = new int[1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            int[] ndp = new int[i + 2];
            if (s.charAt(i) == 'D')
                for (int j = i; j >= 0; j--) {
                    dp[j] += (j == i) ? 0 : dp[j + 1];
                    dp[j] %= M;
                    ndp[j] = dp[j];
                }
            else for (int j = 1; j <= i + 1; j++) {
                dp[j - 1] += (j == 1) ? 0 : dp[j - 2];
                dp[j - 1] %= M;
                ndp[j] = dp[j - 1];
            }
            dp = ndp;
        }
        return IntStream.of(dp).reduce(0, (o1, o2) -> ((o1 + o2) % M));
    }
}
