package main.java;

public class Solution_48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++)
            for (int j = i; j < matrix.length - 1 - i; j++) {
                matrix[i][j] += matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = matrix[i][j] - matrix[j][matrix.length - 1 - i];
                matrix[i][j] -= matrix[j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][i] += matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i] - matrix[i][j];
                matrix[matrix.length - 1 - j][i] -= matrix[i][j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] += matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j] - matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] -= matrix[matrix.length - 1 - j][i];
            }
    }
}
