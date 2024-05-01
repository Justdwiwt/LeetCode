package main.java;

import java.util.stream.IntStream;

public class Solution_91 {
    public int numDecodings(String s) {
        final int length = s.length();
        if (length == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[length + 1];
        dp[0] = 1;

        IntStream.range(0, length).forEach(i -> {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')))
                dp[i + 1] += dp[i - 1];
        });

        return dp[length];
    }
}
