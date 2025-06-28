package main.java;

import java.util.stream.IntStream;

public class Solution_2684 {
    int res = 0, n, m;
    boolean[][] visited;

    public int maxMoves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        IntStream.range(0, grid.length).forEach(i -> dfs(0, i, grid, 0, 0));
        return res;
    }

    private void dfs(int x, int y, int[][] grid, int step, int preNum) {
        if (x >= m || y < 0 || y >= n || grid[y][x] <= preNum || visited[y][x]) return;
        int num = grid[y][x];
        res = Math.max(res, step++);
        visited[y][x] = true;
        dfs(x + 1, y - 1, grid, step, num);
        dfs(x + 1, y, grid, step, num);
        dfs(x + 1, y + 1, grid, step, num);
    }
}
