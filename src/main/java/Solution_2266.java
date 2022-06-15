package main.java;

public class Solution_2266 {
    public int countTexts(String pressedKeys) {
        final int M = (int) (1e9 + 7);
        int[] diff = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        long[] dp = new long[pressedKeys.length()];
        dp[0] = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            dp[i] = dp[i - 1];
            int k = i - 1, cnt = 1;
            char ch = pressedKeys.charAt(i);
            while (cnt < diff[ch - '0'] && k > -1 && ch == pressedKeys.charAt(k)) {
                dp[i] = (dp[i] + (k - 1 > -1 ? dp[k - 1] : 1)) % M;
                cnt++;
                k--;
            }
        }
        return ((int) dp[pressedKeys.length() - 1] + M) % M;
    }
}
