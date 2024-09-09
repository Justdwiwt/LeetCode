package main.java;

public class Solution_2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                boolean onLine = i == j || (i + j == n - 1);
                if (onLine && grid[i][j] == 0 || !onLine && grid[i][j] != 0) return false;
            }
        return true;
    }
}
