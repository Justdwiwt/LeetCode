package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_827 {
    int t = -1, count = 0, m, n;
    Map<Integer, Integer> map;
    Set<Integer> visited;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int largestIsland(int[][] grid) {
        int max = 0;
        map = new HashMap<>();
        visited = new HashSet<>();
        map.put(0, 0);
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    reshape(i, j, grid);
                    map.put(t, count);
                    t--;
                    if (max < count) max = count;
                    count = 0;
                }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) {
                    int res = 1;
                    for (int k = 0; k < 4; k++) res += findMax(i + dx[k], j + dy[k], grid);
                    if (max < res) max = res;
                    visited.clear();
                }
        return max;
    }

    public void reshape(int x, int y, int[][] grid) {
        if (x < 0 || x == m || y < 0 || y == n || grid[x][y] <= 0) return;
        count++;
        grid[x][y] = t;
        IntStream.range(0, 4).forEach(i -> reshape(x + dx[i], y + dy[i], grid));
    }

    public int findMax(int x, int y, int[][] grid) {
        if (x < 0 || x == m || y < 0 || y == n || visited.contains(grid[x][y])) return 0;
        visited.add(grid[x][y]);
        return map.get(grid[x][y]);
    }
}
