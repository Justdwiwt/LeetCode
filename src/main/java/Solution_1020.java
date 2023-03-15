package main.java;

import java.util.stream.IntStream;

public class Solution_1020 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((i == 0 || j == 0 || i == (m - 1) || j == (n - 1)) && grid[i][j] == 1) dfs(grid, i, j);

        for (int[] ints : grid)
            res += IntStream.range(0, n).filter(j -> ints[j] == 1).count();
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
