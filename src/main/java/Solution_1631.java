package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1631 {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] map = new boolean[n][m];
        int[][] steps = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue.add(new int[]{0, 0, 0});
        while (queue.size() > 0) {
            int[] first = queue.poll();
            if (map[first[0]][first[1]])
                continue;
            map[first[0]][first[1]] = true;
            if (first[0] == n - 1 && first[1] == m - 1)
                return first[2];
            Arrays.stream(steps).forEach(step -> {
                int i = first[0] + step[0];
                int j = first[1] + step[1];
                if (i >= 0 && i < n && j >= 0 && j < m && !map[i][j]) {
                    int cnt = Math.max(first[2], Math.abs(grid[i][j] - grid[first[0]][first[1]]));
                    queue.add(new int[]{i, j, cnt});
                }
            });
        }
        return 0;
    }
}
