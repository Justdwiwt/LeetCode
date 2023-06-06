package main.java;

import java.util.Arrays;

public class Solution_764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] grid = new boolean[n][n];
        int max = 0;
        Arrays.stream(mines).forEach(m -> grid[m[0]][m[1]] = true);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (!grid[i][j]) {
                    int t = getPlus(grid, i, j);
                    max = Math.max(max, t);
                }
        return max;
    }

    private int getPlus(boolean[][] g, int x, int y) {
        int r = 0;
        while (x - r >= 0 && x + r < g.length && y - r >= 0 && y + r < g[0].length && !(g[x - r][y] || g[x + r][y] || g[x][y - r] || g[x][y + r]))
            r++;
        return r;
    }
}
