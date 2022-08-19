package main.java;

public class Solution_1975 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE, count = 0;
        long sum = 0;
        for (int[] ints : matrix)
            for (int j = 0; j < n; j++) {
                int abs = Math.abs(ints[j]);
                sum += abs;
                min = Math.min(min, abs);
                if (ints[j] < 0) count++;
            }
        return (count % 2 == 0) ? sum : sum - 2L * min;
    }
}
