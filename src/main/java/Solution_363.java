package main.java;

import java.util.TreeSet;

public class Solution_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        int res = Integer.MIN_VALUE;
        for (int top = 1; top <= m; top++)
            for (int bot = top; bot <= m; bot++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int r = 1; r <= n; r++) {
                    int cur = sum[bot][r] - sum[top - 1][r];
                    if (cur == k) return k;
                    if (!ts.isEmpty()) {
                        Integer pre = ts.ceiling(cur - k);
                        if (pre != null) res = Math.max(res, cur - pre);
                    }
                    ts.add(cur);
                }
            }
        return res;
    }
}
