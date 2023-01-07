package main.java;

import java.util.stream.IntStream;

public class Solution_1351 {
    public int countNegatives(int[][] grid) {
        int col = grid[0].length;
        int res = 0;
        for (int[] ints : grid)
            res += IntStream.range(0, col).filter(j -> ints[j] < 0).count();
        return res;
    }
}
