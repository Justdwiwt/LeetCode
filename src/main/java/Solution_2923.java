package main.java;

import java.util.Arrays;

public class Solution_2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length, cnt = 0, i = 0;
        for (; i < n; i++) {
            cnt += Arrays.stream(grid[i]).sum();
            if (cnt == n - 1) break;
            cnt = 0;
        }
        return i;
    }
}
