package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_2596 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}, dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] != 0) return false;
        q.add(new int[]{0, 0});
        int target = n * n - 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] != grid[x][y] + 1) continue;
                if (grid[nx][ny] == target) return true;
                q.add(new int[]{nx, ny});
            }
        }
        return false;
    }
}
