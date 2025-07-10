package main.java;

import java.util.Arrays;

public class Solution_2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
        int[][] pre = new int[n][m];
        long[][] ans = new long[2][m];
        for (int i = 1; i < n; i++) {
            int I = i & 1;
            for (int j = 1; j < m; j++) {
                ans[I][j] = ans[I ^ 1][j - 1] | (1L << grid[i - 1][j - 1]);
                pre[i][j] = pre[i - 1][j - 1] + ((ans[I ^ 1][j - 1] & (1L << grid[i - 1][j - 1])) == 0 ? 1 : 0);
            }
        }
        Arrays.fill(ans[0], 0);
        Arrays.fill(ans[1], 0);
        for (int i = n - 2; i >= 0; i--) {
            int I = i & 1;
            for (int j = 0; j < m - 1; j++) {
                ans[I][j] = ans[I ^ 1][j + 1] | (1L << grid[i + 1][j + 1]);
                res[i][j] = res[i + 1][j + 1] + ((ans[I ^ 1][j + 1] & (1L << grid[i + 1][j + 1])) == 0 ? 1 : 0);
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[i][j] = Math.abs(res[i][j] - pre[i][j]);
        return res;
    }
}
