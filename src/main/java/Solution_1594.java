package main.java;

import java.util.stream.IntStream;

public class Solution_1594 {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        long[][][] res = new long[rows][columns][2];
        res[0][0][0] = res[0][0][1] = grid[0][0];
        IntStream.range(1, rows).forEach(i -> res[i][0][0] = res[i][0][1] = res[i - 1][0][0] * grid[i][0]);
        IntStream.range(1, columns).forEach(i -> res[0][i][0] = res[0][i][1] = res[0][i - 1][0] * grid[0][i]);
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < columns; j++)
                if (grid[i][j] >= 0) {
                    res[i][j][0] = Math.min(res[i][j - 1][0], res[i - 1][j][0]) * grid[i][j];
                    res[i][j][1] = Math.max(res[i][j - 1][1], res[i - 1][j][1]) * grid[i][j];
                } else {
                    res[i][j][1] = Math.min(res[i][j - 1][0], res[i - 1][j][0]) * grid[i][j];
                    res[i][j][0] = Math.max(res[i][j - 1][1], res[i - 1][j][1]) * grid[i][j];
                }
        return res[rows - 1][columns - 1][1] < 0 ? -1 : (int) (res[rows - 1][columns - 1][1] % (1000000007));
    }
}
