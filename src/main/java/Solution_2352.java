package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2352 {
    public int equalPairs(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int n = grid.length;
        int[][] grid2 = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid2[j][i] = grid[i][j];
        return Arrays.stream(grid)
                .mapToInt(ints -> (int) IntStream.range(0, n).filter(j -> Arrays.equals(ints, grid2[j])).count())
                .sum();
    }
}
