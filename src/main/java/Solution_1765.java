package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution_1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        IntStream.range(0, m).forEach(i -> Arrays.fill(height[i], -1));
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.addLast(new int[]{i, j});
                }
        while (!q.isEmpty()) {
            int[] temp = q.removeFirst();
            for (int j = 0; j < 4; j++) {
                int x = temp[0] + dx[j];
                int y = temp[1] + dy[j];
                if (x < 0 || x >= m || y < 0 || y >= n || height[x][y] != -1)
                    continue;
                height[x][y] = height[temp[0]][temp[1]] + 1;
                q.addLast(new int[]{x, y});
            }
        }
        return height;
    }
}
