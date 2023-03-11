package main.java;

public class Solution_1034 {
    private void dfs(int[][] grid, int x, int y, int pre, int color, int[][] mask) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != pre) {
            return;
        }
        grid[x][y] = color;
        mask[x][y] = 1;
        dfs(grid, x - 1, y, pre, color, mask);
        dfs(grid, x + 1, y, pre, color, mask);
        dfs(grid, x, y - 1, pre, color, mask);
        dfs(grid, x, y + 1, pre, color, mask);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        int pre = grid[row][col];
        int[][] mask = new int[grid.length][grid[0].length];
        dfs(grid, row, col, pre, color, mask);
        for (int i = 1; i < grid.length - 1; i++)
            for (int j = 1; j < grid[0].length - 1; j++)
                if (mask[i][j] == 1 && mask[i - 1][j] == 1 && mask[i + 1][j] == 1 && mask[i][j - 1] == 1 && mask[i][j + 1] == 1)
                    grid[i][j] = pre;
        return grid;
    }
}
