package main.java;

public class Solution_931 {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length, res = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++)
            for (int j = 0; j < N; j++)
                if (j == 0) matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                else
                    matrix[i][j] += j == N - 1
                            ? Math.min(matrix[i - 1][j - 1], matrix[i - 1][j])
                            : Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
        for (int j = 0; j < N; j++) res = Math.min(res, matrix[N - 1][j]);
        return res;
    }
}
