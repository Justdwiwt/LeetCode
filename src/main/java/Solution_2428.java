package main.java;

public class Solution_2428 {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
        int ans = 0;
        for (int i = 3; i <= m; i++)
            for (int j = 3; j <= n; j++)
                ans = Math.max(ans, preSum[i][j] - preSum[i - 3][j] - preSum[i][j - 3] + preSum[i - 3][j - 3] - grid[i - 2][j - 1] - grid[i - 2][j - 3]);
        return ans;
    }
}
