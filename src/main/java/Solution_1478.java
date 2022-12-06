package main.java;

import java.util.Arrays;

public class Solution_1478 {
    public int minDistance(int[] h, int k) {
        int n = h.length;
        Arrays.sort(h);
        int[][] cost = new int[n][n], f = new int[n][k + 1];
        for (int i = n - 2; i >= 0; --i)
            for (int j = i + 1; j < n; ++j) {
                cost[i][j] = cost[i + 1][j - 1] + h[j] - h[i];
                if (i == 0) f[j][1] = cost[0][j];
            }
        for (int i = 2; i <= k; i++)
            for (int end = i - 1; end < n; end++) {
                f[end][i] = 0x3f3f3f3f;
                for (int start = i - 1; start <= end; start++)
                    f[end][i] = Math.min(f[start - 1][i - 1] + cost[start][end], f[end][i]);
            }
        return f[n - 1][k];
    }
}
