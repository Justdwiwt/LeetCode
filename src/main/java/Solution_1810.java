package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1810 {
    abstract static class GridMaster {
        abstract boolean canMove(char direction);

        abstract int move(char direction);

        abstract boolean isTarget();
    }

    private static final char[] directions = new char[]{'U', 'L', 'D', 'R'};

    private static final int[][] offsets = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    private static final int m = 200;
    private static final int n = 200;

    private final int[][] grid = new int[m][n];

    private int endX;
    private int endY;

    public int findShortestPath(GridMaster master) {
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, -1));

        dfs(master, 100, 100);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{100, 100, 0});
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            for (int i = 0; i < 4; i++) {
                int r = a[0] + offsets[i][0];
                int c = a[1] + offsets[i][1];
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) continue;
                int k = a[2] + grid[r][c];
                if (r == endX && c == endY) return k;
                grid[r][c] = -1;
                pq.offer(new int[]{r, c, k});
            }
        }

        return -1;
    }

    private void dfs(GridMaster master, int x, int y) {
        IntStream.range(0, 4).filter(i -> master.canMove(directions[i])).forEach(i -> {
            int r = x + offsets[i][0];
            int c = y + offsets[i][1];
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != -1) return;
            grid[r][c] = master.move(directions[i]);
            if (master.isTarget()) {
                endX = r;
                endY = c;
            }
            dfs(master, r, c);
            master.move(directions[(i + 2) % 4]);
        });
    }
}
