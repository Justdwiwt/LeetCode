package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_864 {
    private final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), startX = -1, startY = -1, count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                } else if (c >= 'a' && c < 'g') count = Math.max(count, c - 'a' + 1);
            }
        int max = 1 << count;
        int[][][] step = new int[m][n][max];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) Arrays.fill(step[i][j], (int) 1e9);
        step[startX][startY][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0, 0});
        while (q.size() > 0) {
            int[] a = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = a[0] + move[i][0], y = a[1] + move[i][1];
                if (x < 0 || x == m || y < 0 || y == n) continue;
                char c = grid[x].charAt(y);
                if (c == '#') continue;
                if (c == '.' || c == '@') {
                    if (step[x][y][a[2]] > a[3] + 1) {
                        step[x][y][a[2]] = a[3] + 1;
                        q.add(new int[]{x, y, a[2], a[3] + 1});
                    }
                } else if (Character.isUpperCase(c)) {
                    if ((a[2] & (1 << (c - 'A'))) == 0 || step[x][y][a[2]] <= a[3] + 1) continue;
                    step[x][y][a[2]] = a[3] + 1;
                    q.add(new int[]{x, y, a[2], a[3] + 1});
                } else {
                    if (step[x][y][a[2] | (1 << (c - 'a'))] <= a[3] + 1) continue;
                    if (max - 1 == (a[2] | (1 << (c - 'a')))) return a[3] + 1;
                    step[x][y][a[2] | (1 << (c - 'a'))] = a[3] + 1;
                    q.add(new int[]{x, y, a[2] | (1 << (c - 'a')), a[3] + 1});
                }
            }
        }
        return -1;
    }
}
