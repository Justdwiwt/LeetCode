package main.java;

import java.util.stream.IntStream;

public class Solution_1420 {
    int M = (int) 1e9 + 7;

    public int numOfArrays(int n, int m, int k) {
        long[][][] count = new long[55][105][55];
        IntStream.rangeClosed(1, m).forEach(i -> count[1][i][1] = 1);
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int p = 1; p <= k; p++) {
                    count[i][j][p] = count[i - 1][j][p] * j;
                    for (int w = 1; w < j; w++)
                        count[i][j][p] += count[i - 1][w][p - 1];
                    count[i][j][p] %= M;
                }
        long res = IntStream.rangeClosed(1, m).mapToLong(i -> count[n][i][k]).sum();
        return (int) (res % M);
    }
}
