package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_994 {
    public int orangesRotting(int[][] grid) {
        int[] p1 = {1, -1, 0, 0}, p2 = {0, 0, 1, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int j = 0; j < p1.length; j++) {
                    assert temp != null;
                    int x = temp[0] + p1[j], y = temp[1] + p2[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            if (!queue.isEmpty()) steps++;
        }

        for (int[] ints : grid)
            for (int j = 0; j < grid[0].length; j++)
                if (ints[j] == 1) return -1;
        return steps;
    }
}
