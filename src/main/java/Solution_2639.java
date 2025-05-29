package main.java;

import java.util.stream.IntStream;

public class Solution_2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        IntStream.range(0, n).forEach(i -> {
            for (int[] ints : grid)
                res[i] = Math.max(res[i], String.valueOf(ints[i]).length());
        });
        return res;
    }
}
