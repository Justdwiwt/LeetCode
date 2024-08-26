package main.java;

import java.util.Arrays;

public class Solution_2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid[0].length, n = grid.length;
        int[][] dp = new int[2][m];
        System.arraycopy(grid[0], 0, dp[0], 0, m);
        for (int i = 1; i < n; i++) {
            int I = i & 1;
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) min = Math.min(min, dp[I ^ 1][k] + moveCost[grid[i - 1][k]][j]);
                dp[I][j] = min + grid[i][j];
            }
        }
        return Arrays.stream(dp[(n - 1) & 1]).min().getAsInt();
    }
}
