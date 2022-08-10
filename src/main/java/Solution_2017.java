package main.java;

import java.util.Arrays;

public class Solution_2017 {
    public long gridGame(int[][] grid) {
        long res = Long.MAX_VALUE, lowerLeft = 0, upperRight = Arrays.stream(grid[0]).asLongStream().sum();
        for (int i = 0; i < grid[0].length; ++i) {
            upperRight -= grid[0][i];
            res = Math.min(res, Math.max(upperRight, lowerLeft));
            lowerLeft += grid[1][i];
        }
        return res;
    }
}
