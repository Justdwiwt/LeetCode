package main.java;

import java.util.stream.IntStream;

public class Solution_375 {
    public int getMoneyAmount(int n) {
        int[][] res = new int[n + 1][n + 1];
        IntStream.range(1, n).forEach(i -> res[i][i + 1] = i);
        for (int d = 2; d < n; d++)
            for (int i = 1; i <= n - d; i++) {
                res[i][i + d] = Math.min(i + res[i + 1][i + d], i + d + res[i][i + d - 1]);
                for (int j = i + 1; j < i + d; j++)
                    res[i][i + d] = Math.min(res[i][i + d], j + Math.max(res[i][j - 1], res[j + 1][i + d]));
            }
        return res[1][n];
    }
}
