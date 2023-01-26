package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1284 {
    private void flip(int[][] mat, int row, int col) {
        int top = row - 1, bottom = row + 1, left = col - 1, right = col + 1;
        mat[row][col] ^= 1;
        if (top >= 0)
            mat[top][col] ^= 1;
        if (bottom < mat.length)
            mat[bottom][col] ^= 1;
        if (left >= 0)
            mat[row][left] ^= 1;
        if (right < mat[0].length)
            mat[row][right] ^= 1;
    }

    private int[][] copy(int[][] mat) {
        int n = mat[0].length;
        return Arrays.stream(mat).map(ints -> Arrays.copyOf(ints, n)).toArray(int[][]::new);
    }

    private boolean isAllZero(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        return IntStream.range(0, m).noneMatch(i -> IntStream.range(0, n).anyMatch(j -> mat[i][j] == 1));
    }

    public int minFlips(int[][] mat) {
        if (isAllZero(mat)) return 0;
        int m = mat.length, n = mat[0].length;
        int mask = (int) Math.pow(2, m * n);
        int res = 10;
        for (int i = 0; i < mask; i++) {
            int[][] arr = copy(mat);
            int count = 0;
            for (int j = 0; j < m * n; j++)
                if ((1 << j & i) >> j == 1) {
                    flip(arr, j / n, j - j / n * n);
                    count++;
                    if (isAllZero(arr))
                        res = Math.min(res, count);
                }
        }
        return res == 10 ? -1 : res;
    }
}
