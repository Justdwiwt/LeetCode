package main.java;

public class Solution_1463 {
    private int row;

    private int col;

    public int cherryPickup(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int[][][] cache = new int[row][col][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                for (int k = 0; k < col; k++)
                    cache[i][j][k] = -1;
        return dfs(grid, 0, 0, col - 1, cache);
    }

    private int dfs(int[][] grid, int i, int j, int k, int[][][] cache) {
        if (i >= row) return 0;
        if (cache[i][j][k] != -1) return cache[i][j][k];
        int cur = grid[i][j] + grid[i][k];
        int res = 0;
        for (int dj = -1; dj < 2; dj++) {
            if (j + dj < 0 || j + dj >= col) continue;
            for (int dk = -1; dk < 2; dk++) {
                if (k + dk < 0 || k + dk >= col) continue;
                if (j + dj < k + dk) res = Math.max(res, cur + dfs(grid, i + 1, j + dj, k + dk, cache));
            }
        }
        return cache[i][j][k] = res;
    }
}
