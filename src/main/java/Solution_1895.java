package main.java;

import java.util.stream.IntStream;

public class Solution_1895 {
    int[][] pre;

    public int largestMagicSquare(int[][] grid) {
        pre = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++)
            for (int j = 1; j <= grid[0].length; j++)
                pre[i][j] = grid[i - 1][j - 1] + pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1];
        for (int l = Math.min(grid.length, grid[0].length); l >= 2; l--)
            if (existsMagicSquare(grid, l)) return l;
        return 1;
    }

    private boolean existsMagicSquare(int[][] grid, int l) {
        for (int i = 0; i <= grid.length - l; i++)
            for (int j = 0; j <= grid[0].length - l; j++)
                if (isMagicSquare(grid, i, j, l)) return true;
        return false;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j, int l) {
        int sum = IntStream.range(0, l).map(k -> grid[i + k][j + k]).sum();
        int sumDia = IntStream.range(0, l).map(k -> grid[i + k][j + l - 1 - k]).sum();
        if (sum != sumDia) return false;
        for (int p = i; p < i + l; p++)
            if (sum != pre[p + 1][j + l] - pre[p][j + l] - pre[p + 1][j] + pre[p][j])
                return false;
        return IntStream.range(j, j + l).noneMatch(q -> sum != pre[i + l][q + 1] - pre[i][q + 1] - pre[i + l][q] + pre[i][q]);
    }
}
