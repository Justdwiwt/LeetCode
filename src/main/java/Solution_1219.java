package main.java;

public class Solution_1219 {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) res = Math.max(res, dfs(grid, i, j));
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        int value = grid[i][j];
        grid[i][j] = 0;
        int up = dfs(grid, i + 1, j);
        int down = dfs(grid, i - 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        grid[i][j] = value;
        return Math.max(Math.max(up, down), Math.max(left, right)) + value;
    }
}
