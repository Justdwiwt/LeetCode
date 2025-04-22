package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_2577 {
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        IntStream.range(0, m).forEach(i -> Arrays.fill(ans[i], (int) 2e9));
        ans[1][0] = grid[1][0] % 2 == 1 ? grid[1][0] : grid[1][0] + 1;
        ans[0][1] = grid[0][1] % 2 == 1 ? grid[0][1] : grid[0][1] + 1;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.add(new int[]{1, 0, ans[1][0]});
        q.add(new int[]{0, 1, ans[0][1]});
        while (true) {
            int[] a = q.poll();
            if (a != null && a[2] > ans[a[0]][a[1]]) continue;
            for (int[] mo : move) {
                assert a != null;
                int x = a[0] + mo[0], y = a[1] + mo[1];
                if (x >= 0 && x < m & y >= 0 && y < n) {
                    int t = Math.max(grid[x][y] % 2 == (x + y) % 2 ? grid[x][y] : grid[x][y] + 1, a[2] + 1);
                    if (x == m - 1 && y == n - 1) return t;
                    if (t < ans[x][y]) {
                        ans[x][y] = t;
                        q.add(new int[]{x, y, t});
                    }
                }
            }
        }
    }
}
