package main.java;

public class Solution_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                res += Math.min(rowMax[i], colMax[j]) - grid[i][j];
        return res;
    }
}
