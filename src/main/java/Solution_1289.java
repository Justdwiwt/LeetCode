package main.java;

public class Solution_1289 {
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length, n = arr[0].length, res = Integer.MAX_VALUE;
        for (int i = 1; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    if (j == k) continue;
                    min = Math.min(min, arr[i][j] + arr[i - 1][k]);
                }
                arr[i][j] = min;
            }
        for (int j = 0; j < n; ++j) res = Math.min(res, arr[m - 1][j]);
        return res;
    }
}
