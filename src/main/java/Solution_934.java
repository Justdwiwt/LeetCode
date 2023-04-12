package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution_934 {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private final Deque<int[]> dq = new ArrayDeque<>();
    private int[][] grid;
    private int N;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        for (int i = 0, x = 1; i < N && x == 1; ++i)
            for (int j = 0; j < N; ++j)
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    x = 0;
                    break;
                }
        int res = 0;
        while (true) {
            for (int i = dq.size(); i > 0; --i) {
                int[] p = dq.pollFirst();
                for (int k = 0; k < 4; ++k) {
                    assert p != null;
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        if (grid[x][y] == 1) return res;
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            dq.offer(new int[]{x, y});
                        }
                    }
                }
            }
            ++res;
        }
    }

    private void dfs(int i, int j) {
        grid[i][j] = 2;
        dq.offer(new int[]{i, j});
        IntStream.range(0, 4).forEach(k -> {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == 1) dfs(x, y);
        });
    }
}
