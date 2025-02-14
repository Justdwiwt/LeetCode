package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] res = new int[queries.length][2];
        IntStream.range(0, queries.length).forEach(i -> {
            res[i][0] = queries[i];
            res[i][1] = i;
        });
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> deque = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[queries.length];
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int t = 0;
        for (int i = 0; i < queries.length; i++) {
            if (!vis[0][0] && grid[0][0] < res[i][0]) {
                deque.add(new int[]{grid[0][0], 0, 0});
                vis[0][0] = true;
            }
            while (!deque.isEmpty() && res[i][0] > deque.peek()[0]) {
                int[] p = deque.poll();
                t++;
                Arrays.stream(dirs).forEach(dir -> {
                    int x = dir[0] + p[1];
                    int y = dir[1] + p[2];
                    if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y]) return;
                    deque.add(new int[]{grid[x][y], x, y});
                    vis[x][y] = true;
                });
            }
            ans[i] = t;

        }
        int[] tt = new int[queries.length];
        IntStream.range(0, queries.length).forEach(i -> tt[res[i][1]] = ans[i]);
        return tt;
    }
}
