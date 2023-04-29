package main.java;

public class Solution_883 {
    public int projectionArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxrow = 0;
            int maxcol = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) ++res;
                maxrow = Math.max(maxrow, grid[i][j]);
                maxcol = Math.max(maxcol, grid[j][i]);
            }
            res += maxrow;
            res += maxcol;
        }
        return res;
    }
}
