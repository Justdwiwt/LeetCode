package main.java;

import java.util.stream.IntStream;

public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return IntStream.range(0, matrix.length).anyMatch(i -> IntStream.range(0, matrix[i].length).anyMatch(j -> matrix[i][j] == target));
    }
}
