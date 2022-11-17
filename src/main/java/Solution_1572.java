package main.java;

import java.util.stream.IntStream;

public class Solution_1572 {
    public int diagonalSum(int[][] mat) {
        int sum;
        int l = mat.length;
        sum = IntStream.range(0, l).map(i -> mat[i][i] + mat[i][l - 1 - i]).sum();
        return sum - (l % 2 == 1 ? mat[l / 2][l / 2] : 0);
    }
}
