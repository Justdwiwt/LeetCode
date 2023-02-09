package main.java;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution_1210 {
    private static final int[][] dirs = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] isVisited = new boolean[n][n][2];
        isVisited[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int step = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                int[] arr = queue.poll();
                for (int[] dir : dirs) {
                    int x1 = Objects.requireNonNull(arr)[0] + dir[0], y1 = arr[1] + dir[1], z1 = arr[2] ^ dir[2];
                    int x2 = x1 + z1, y2 = y1 + (z1 ^ 1);
                    if (x2 < n && y2 < n && !isVisited[x1][y1][z1] && grid[x1][y1] == 0 && grid[x2][y2] == 0
                            && (dir[2] == 0 || grid[x1 + 1][y1 + 1] == 0)) {
                        if (x1 == n - 1 && y1 == n - 2) return step;
                        isVisited[x1][y1][z1] = true;
                        queue.offer(new int[]{x1, y1, z1});
                    }
                }
                len--;
            }
            step++;
        }
        return -1;
    }
}
