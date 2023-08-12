package main.java;

public class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (char c : str.toCharArray())
                if (c == '0') zeroNum++;
                else oneNum++;
            for (int i = m; i >= zeroNum; i--)
                for (int j = n; j >= oneNum; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        }
        return dp[m][n];
    }
}
