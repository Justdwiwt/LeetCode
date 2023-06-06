package main.java;

import java.util.stream.IntStream;

public class Solution_766 {
    public Boolean isToeplitzMatrix(int[][] matrix) {
        return IntStream.range(0, matrix.length - 1)
                .noneMatch(i -> IntStream.range(0, matrix[0].length - 1).anyMatch(j -> matrix[i][j] != matrix[i + 1][j + 1]));
    }
}
