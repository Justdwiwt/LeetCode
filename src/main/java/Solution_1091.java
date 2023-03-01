package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1091 {
    private static final int[][] diff = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        q.offer(new int[]{0, 0, 1});
        visit[0][0] = true;
        int[] t;
        while (!q.isEmpty()) {
            t = q.poll();
            if (t[0] == grid.length - 1 && t[1] == grid[0].length - 1) return t[2];
            for (int[] d : diff) {
                int x = t[0] + d[0];
                int y = t[1] + d[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || visit[x][y])
                    continue;
                visit[x][y] = true;
                q.offer(new int[]{x, y, t[2] + 1});
            }
        }
        return -1;
    }
}
