package main.java;

import java.util.stream.IntStream;

public class Solution_1706 {
    public int[] findBall(int[][] grid) {
        return IntStream.range(0, grid[0].length).map(i -> process(grid, 0, i)).toArray();
    }

    private int process(int[][] grid, int row, int col) {
        if (row == grid.length) return col;
        if (col == 0 && grid[row][col] == -1
                || col == grid[0].length - 1 && grid[row][col] == 1
                || grid[row][col] == 1 && grid[row][col + 1] == -1
                || grid[row][col] == -1 && grid[row][col - 1] == 1) {
            return -1;
        }
        if (grid[row][col] == 1) return process(grid, row + 1, col + 1);
        return process(grid, row + 1, col - 1);

    }
}
