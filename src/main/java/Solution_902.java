package main.java;

public class Solution_902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String maxNum = Integer.toString(n);
        int[][] dp = new int[maxNum.length() + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (String digit : digits)
                if (digit.charAt(0) == maxNum.charAt(i - 1)) dp[i][1] = dp[i - 1][1];
                else if (digit.charAt(0) < maxNum.charAt(i - 1)) dp[i][0] += dp[i - 1][1];
                else break;
            if (i >= 2) dp[i][0] += dp[i - 1][0] * digits.length + digits.length;
        }
        return dp[maxNum.length()][0] + dp[maxNum.length()][1];
    }
}
