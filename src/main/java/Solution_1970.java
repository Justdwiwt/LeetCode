package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1970 {
    private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, res = 0;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (canWalk(cells, row, col, mid)) {
                res = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return res;
    }

    private boolean canWalk(int[][] cells, int row, int col, int when) {
        int[][] grid = new int[row][col];

        IntStream.range(0, when).forEach(i -> grid[cells[i][0] - 1][cells[i][1] - 1] = 1);
        Queue<int[]> queue = new ArrayDeque<>();

        IntStream.range(0, col).filter(c -> grid[0][c] == 0).forEach(c -> {
            queue.offer(new int[]{0, c});
            grid[0][c] = 1;
        });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == row - 1) return true;

            Arrays.stream(dir).forEach(direction -> {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (nr < 0 || nr == row || nc < 0 || nc == col) return;
                if (grid[nr][nc] == 1) return;
                grid[nr][nc] = 1;
                queue.offer(new int[]{nr, nc});
            });
        }

        return false;
    }
}
