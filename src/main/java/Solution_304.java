package main.java;

import java.util.stream.IntStream;

public class Solution_304 {
    static class NumMatrix {
        int[][] matrix;
        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            int m = matrix.length;
            int n = 0;
            if (m != 0) n = matrix[0].length;
            preSum = new int[m][n + 1];
            for (int i = 0; i < m; i++)
                for (int j = 1; j < n + 1; j++)
                    preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return IntStream.rangeClosed(row1, row2).map(i -> preSum[i][col2 + 1] - preSum[i][col1]).sum();
        }
    }
}
