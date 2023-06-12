package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[55][55];
        for (int i = 0; i <= n; i++) Arrays.fill(res[i], -(int) 1e7);
        for (int i = 1; i <= n; i++) {
            int[][] arr = new int[55][55];
            IntStream.rangeClosed(0, n).forEach(j -> Arrays.fill(arr[j], -(int) 1e7));
            for (int j = 1; j <= n; j++)
                if (i == 1 && j == 1) arr[i][i] = grid[0][0];
                else for (int k = 1; k <= n; k++) {
                    int p = i + j - k;
                    if (p < 1 || p > n) continue;
                    if (i + j == k || grid[i - 1][j - 1] == -1 || grid[k - 1][p - 1] == -1) arr[j][k] = -(int) 1e7;
                    else {
                        arr[j][k] = Math.max(Math.max(res[j][k - 1], arr[j - 1][k]), Math.max(res[j][k], arr[j - 1][k - 1])) + grid[i - 1][j - 1] + grid[k - 1][p - 1];
                        if (i == k) arr[j][k] -= grid[i - 1][j - 1];
                        if (arr[j][k] < 0) arr[j][k] = -(int) 1e7;
                    }
                }
            res = arr;
        }
        return Math.max(0, res[n][n]);
    }
}
