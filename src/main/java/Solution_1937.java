package main.java;

public class Solution_1937 {
    private static final long M = Long.MIN_VALUE / 2;

    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] A = new long[n], cumMaxL = new long[n], cumMaxR = new long[n];
        for (int j = 0; j < n; j++) A[j] = points[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) cumMaxL[j] = Math.max(j == 0 ? M : cumMaxL[j - 1], A[j] + j);
            for (int j = n - 1; j >= 0; j--) cumMaxR[j] = Math.max(j == n - 1 ? M : cumMaxR[j + 1], A[j] - j);
            for (int j = 0; j < n; j++) A[j] = points[i][j] + Math.max(cumMaxL[j] - j, cumMaxR[j] + j);
        }
        long res = M;
        for (int j = 0; j < n; j++) res = Math.max(res, A[j]);
        return res;
    }
}
