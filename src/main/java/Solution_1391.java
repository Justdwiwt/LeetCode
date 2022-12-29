package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1391 {
    public boolean hasValidPath(int[][] grid) {
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] conn = new int[][]{{2, 3}, {0, 1}, {1, 2}, {1, 3}, {0, 2}, {0, 3}};
        int m = grid.length, n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        dp[m - 1][n - 1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{m - 1, n - 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int neighbor : conn[grid[cur[0]][cur[1]] - 1]) {
                int x = cur[0] + direction[neighbor][0];
                int y = cur[1] + direction[neighbor][1];
                int target = neighbor < 2 ? 1 - neighbor : 5 - neighbor;
                if (x >= 0 && x < m && y >= 0 && y < n && !dp[x][y] && (conn[grid[x][y] - 1][0] == target || conn[grid[x][y] - 1][1] == target)) {
                    dp[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return dp[0][0];
    }
}
