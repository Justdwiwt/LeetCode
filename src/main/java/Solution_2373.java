package main.java;

public class Solution_2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length, m = grid.length - 2;
        int[][] res = new int[m][m];
        for (int i = 1; i < n - 1; i++)
            for (int j = 1; j < n - 1; j++) {
                int max = 0;
                for (int k = i - 1; k < i + 2; k++)
                    for (int v = j - 1; v < j + 2; v++)
                        if (grid[k][v] > max) max = grid[k][v];
                res[i - 1][j - 1] = max;
            }
        return res;
    }
}
