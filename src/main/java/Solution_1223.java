package main.java;

public class Solution_1223 {
    final int M = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n + 1][7];
        for (int i = 1; i <= 1; i++)
            for (int j = 1; j <= 6; j++) dp[i][j] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= 6; j++) {
                int res = 0;
                int idx = i - rollMax[j - 1] - 1;
                for (int k = 1; k <= 6; k++) {
                    res = (res + dp[i - 1][k]) % M;
                    if (k != j && idx > 0) res = (((res - dp[i - rollMax[j - 1] - 1][k]) % M + M)) % M;
                }
                if (idx == 0) res--;
                dp[i][j] = res % M;
            }
        int sum = 0;
        for (int i = 1; i <= 6; i++) sum = (sum + dp[n][i]) % M;
        return sum;
    }
}
