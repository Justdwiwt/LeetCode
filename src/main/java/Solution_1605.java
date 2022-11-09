package main.java;

public class Solution_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rowSum[i] != 0 || colSum[j] != 0) {
                    matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                    rowSum[i] -= matrix[i][j];
                    colSum[j] -= matrix[i][j];
                }
        return matrix;
    }
}
