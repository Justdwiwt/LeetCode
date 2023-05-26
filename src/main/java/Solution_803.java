package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_803 {
    int count = 0;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        Arrays.stream(hits).filter(hit -> grid[hit[0]][hit[1]] == 1).forEach(hit -> grid[hit[0]][hit[1]] = -1);
        IntStream.range(0, grid[0].length).filter(k -> grid[0][k] == 1).forEach(k -> isWayToTop(grid, 0, k));
        for (int i = hits.length - 1; i >= 0; --i) {
            count = 0;
            if (canHit(grid, hits[i][0], hits[i][1]) && grid[hits[i][0]][hits[i][1]] == -1) {
                isWayToTop(grid, hits[i][0], hits[i][1]);
                res[i] = count - 1;
            }
        }
        return res;
    }

    private void isWayToTop(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        ++count;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) isWayToTop(grid, i + 1, j);
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) isWayToTop(grid, i, j + 1);
        if (i - 1 >= 0 && grid[i - 1][j] == 1) isWayToTop(grid, i - 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == 1) isWayToTop(grid, i, j - 1);
    }

    private boolean canHit(int[][] grid, int i, int j) {
        if (i == 0 || i + 1 < grid.length && grid[i + 1][j] == 2) return true;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 2) return true;
        if (i - 1 >= 0 && grid[i - 1][j] == 2) return true;
        if (j - 1 >= 0 && grid[i][j - 1] == 2) return true;
        if (grid[i][j] == -1) grid[i][j] = 1;
        return false;
    }
}
