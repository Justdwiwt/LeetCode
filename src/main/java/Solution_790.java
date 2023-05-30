package main.java;

public class Solution_790 {
    final int M = (int) 1e9 + 7;
    final int[][] matrix = {{0, 1, 1, 1}, {0, 0, 1, 1}, {0, 1, 0, 1}, {1, 0, 0, 1}};

    public int numTilings(int n) {
        long[] res = new long[]{1, 0, 0, 1};
        for (int i = 1; i < n; i++) {
            long[] arr = new long[4];
            for (int j = 3; j >= 0; j--) {
                for (int k = 0; k < 4; k++) arr[j] += res[k] * matrix[k][j];
                arr[j] %= M;
            }
            res = arr;
        }
        return (int) res[3];
    }
}
