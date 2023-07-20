package main.java;

import java.util.stream.IntStream;

public class Solution_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int count = m * n;
        if (m == r && n == c || count != r * c) return mat;
        int[][] res = new int[r][c];
        IntStream.range(0, count).forEach(i -> res[i / c][i % c] = mat[i / n][i % n]);
        return res;
    }
}
