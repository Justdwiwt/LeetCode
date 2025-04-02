package main.java;

public class Solution_2556 {
    public boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 1) return m > 2;
        if (m == 1) return n != 2;
        if (grid[0][1] == 0 || grid[1][0] == 0 || grid[n - 1][m - 2] == 0 || grid[n - 2][m - 1] == 0) return true;
        return !(dfs(1, 0, n - 1, m - 2, grid, new int[][]{{1, 0}, {0, 1}}) &&
                dfs(0, 1, n - 2, m - 1, grid, new int[][]{{0, 1}, {1, 0}}));
    }

    private boolean dfs(int x, int y, int destX, int destY, int[][] grid, int[][] step) {
        if (x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return false;
        if (x == destX && y == destY) return true;
        boolean f = dfs(x + step[0][0], y + step[0][1], destX, destY, grid, step) ||
                dfs(x + step[1][0], y + step[1][1], destX, destY, grid, step);
        grid[x][y] = 0;
        return f;
    }
}
