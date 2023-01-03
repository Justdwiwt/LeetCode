package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1368 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        dp[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            IntStream.range(0, 4).forEach(i -> {
                int x = cur[0] + dirs[i][0];
                int y = cur[1] + dirs[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n) return;
                int cost = grid[cur[0]][cur[1]] == i + 1 ? 0 : 1;
                if (dp[x][y] > dp[cur[0]][cur[1]] + cost) {
                    dp[x][y] = dp[cur[0]][cur[1]] + cost;
                    queue.offer(new int[]{x, y});
                }
            });
        }
        return dp[m - 1][n - 1];
    }
}
