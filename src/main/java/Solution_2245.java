package main.java;

public class Solution_2245 {
    public int maxTrailingZeros(int[][] grid) {
        int[][][] rowPreSum = new int[grid.length][grid[0].length + 1][2];
        int[][][] colPreSum = new int[grid[0].length][grid.length + 1][2];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                int mul2 = f(grid[i][j], 2), mul5 = f(grid[i][j], 5);
                rowPreSum[i][j + 1][0] = rowPreSum[i][j][0] + mul2;
                rowPreSum[i][j + 1][1] = rowPreSum[i][j][1] + mul5;
                colPreSum[j][i + 1][0] = colPreSum[j][i][0] + mul2;
                colPreSum[j][i + 1][1] = colPreSum[j][i][1] + mul5;
            }
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, Math.min(rowPreSum[i][j + 1][0] + colPreSum[j][i][0], rowPreSum[i][j + 1][1] + colPreSum[j][i][1]));
                res = Math.max(res, Math.min(rowPreSum[i][j + 1][0] + colPreSum[j][grid.length][0] - colPreSum[j][i + 1][0], rowPreSum[i][j + 1][1] + colPreSum[j][grid.length][1] - colPreSum[j][i + 1][1]));
                res = Math.max(res, Math.min(rowPreSum[i][grid[0].length][0] - rowPreSum[i][j][0] + colPreSum[j][i][0], rowPreSum[i][grid[0].length][1] - rowPreSum[i][j][1] + colPreSum[j][i][1]));
                res = Math.max(res, Math.min(rowPreSum[i][grid[0].length][0] - rowPreSum[i][j][0] + colPreSum[j][grid.length][0] - colPreSum[j][i + 1][0], rowPreSum[i][grid[0].length][1] - rowPreSum[i][j][1] + colPreSum[j][grid.length][1] - colPreSum[j][i + 1][1]));
            }
        return res;
    }

    private int f(int k, int m) {
        int res = 0;
        while (k % m == 0) {
            res++;
            k /= m;
        }
        return res;
    }
}
