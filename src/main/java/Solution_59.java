package main.java;

public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = 0, cur = 2;
        res[0][0] = 1;
        while (cur <= n * n) {
            while (j < n - 1 && res[i][j + 1] == 0) res[i][++j] = cur++;
            while (i < n - 1 && res[i + 1][j] == 0) res[++i][j] = cur++;
            while (j > 0 && res[i][j - 1] == 0) res[i][--j] = cur++;
            while (i > 0 && res[i - 1][j] == 0) res[--i][j] = cur++;
        }
        return res;
    }
}
