package main.java;

public class Solution_892 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += grid[i][0] + grid[i][n - 1] + grid[0][i] + grid[n - 1][i];
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) res += 2;
                if (j > 0) res += Math.abs(grid[i][j] - grid[i][j - 1]) + Math.abs(grid[j][i] - grid[j - 1][i]);
            }
        }
        return res;
    }
}
