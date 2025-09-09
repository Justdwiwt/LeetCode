package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_2812 {
    int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dis = new int[n][n];
        int[][] max = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid.get(i).get(j) == 1) q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            for (int[] m : move) {
                int x = a[0] + m[0], y = a[1] + m[1];
                if (x >= 0 && x < n && y >= 0 && y < n && dis[x][y] == 0 && grid.get(x).get(y) == 0) {
                    dis[x][y] = dis[a[0]][a[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        q = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        max[0][0] = dis[0][0];
        q.add(new int[]{0, 0, dis[0][0]});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            if (a[2] < max[a[0]][a[1]]) continue;
            for (int[] m : move) {
                int x = a[0] + m[0], y = a[1] + m[1];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    int d = Math.min(dis[x][y], a[2]);
                    if (d > max[x][y]) {
                        max[x][y] = d;
                        q.add(new int[]{x, y, d});
                    }
                }
            }
        }
        return max[n - 1][n - 1];
    }
}
