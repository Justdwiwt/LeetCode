package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution_2850 {
    public int minimumMoves(int[][] grid) {
        int[] m = new int[9];
        Deque<Integer> q = new ArrayDeque<>();
        IntStream.range(0, 9).forEach(i -> {
            int f = grid[i / 3][i % 3];
            if (f > 1) m[i] = f - 1;
            else if (f == 0) q.add(i);
        });
        recall(q, m, 0);
        return min;
    }

    int min = Integer.MAX_VALUE;

    private void recall(Deque<Integer> q, int[] m, int k) {
        if (q.isEmpty()) {
            min = Math.min(min, k);
            return;
        }
        int j = q.poll();
        IntStream.range(0, 9).filter(i -> m[i] != 0).forEach(i -> {
            int t = Math.abs(j % 3 - i % 3) + Math.abs(j / 3 - i / 3);
            m[i]--;
            recall(q, m, k + t);
            m[i]++;
        });
        q.add(j);
    }
}
