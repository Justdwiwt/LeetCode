package main.java;

public class Solution_2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] oneR = new int[n];
        int[] oneC = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    oneR[i]++;
                    oneC[j]++;
                }
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                diff[i][j] = (oneR[i] + oneC[j] - (m - oneR[i] + n - oneC[j]));

        return diff;
    }
}
