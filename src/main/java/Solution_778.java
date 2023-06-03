package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_778 {
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, grid[0][0]});
        vis[0][0] = true;
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            for (int[] d : dirs) {
                int nx = u[0] + d[0], ny = u[1] + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny]) continue;
                if (nx == n - 1 && ny == nx) return Math.max(u[2], grid[nx][ny]);
                vis[nx][ny] = true;
                pq.add(new int[]{nx, ny, Math.max(u[2], grid[nx][ny])});
            }
        }
        return 0;
    }
}
