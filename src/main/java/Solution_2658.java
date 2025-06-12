package main.java;

import java.util.Arrays;

public class Solution_2658 {
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                ans = Math.max(ans, find(i, j, grid));
        return ans;
    }

    int find(int a, int b, int[][] grid) {
        if (a < 0 || a == grid.length || b < 0 || b == grid[0].length || grid[a][b] == 0)
            return 0;
        int ans = grid[a][b];
        grid[a][b] = 0;
        ans += Arrays.stream(move).mapToInt(m -> find(a + m[0], b + m[1], grid)).sum();
        return ans;
    }
}
