package main.java;

public class Solution_1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                ++row[i];
                ++col[j];
            }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                if (row[i] > 1 || col[j] > 1) ++res;
            }
        return res;
    }
}
