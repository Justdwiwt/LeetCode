package main.java;

public class Solution_1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] row = new int[n + 1][m + 1], col = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j) {
                row[i][j] = row[i][j - 1] + grid[i - 1][j - 1];
                col[i][j] = col[i - 1][j] + grid[i - 1][j - 1];
            }

        int res = 0;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                for (int k = 1; i + k - 1 <= n && j + k - 1 <= m; ++k) {
                    int x = i + k - 1, y = j + k - 1;
                    if (row[i][y] - row[i][j - 1] == k && row[x][y] - row[x][j - 1] == k && col[x][j] - col[i - 1][j] == k && col[x][y] - col[i - 1][y] == k)
                        res = Math.max(res, k);
                }
        return res * res;
    }
}
