package main.java;

public class Solution_2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int[][] dp = new int[floor.length() + 1][numCarpets + 1];
        int num = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++)
                if (i == 0) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE / 2;
            if (i >= 1 && floor.charAt(i - 1) == '1') num++;
            dp[i][0] = num;
        }
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j <= numCarpets; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0));
                dp[i][j] = Math.min(dp[i][j], (i >= carpetLen) ? dp[i - carpetLen][j - 1] : 0);
            }
        return dp[dp.length - 1][numCarpets];
    }
}
