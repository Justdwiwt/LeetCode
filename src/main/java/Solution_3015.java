package main.java;

import java.util.stream.IntStream;

public class Solution_3015 {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] w = new int[n + 1][n + 1];
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                w[i][j] = (i == j ? 0 : INF);

        if (x != y) {
            w[x][y] = 1;
            w[y][x] = 1;
        }

        for (int i = 1; i < n; i++) {
            w[i][i + 1] = 1;
            w[i + 1][i] = 1;
        }

        for (int p = 1; p <= n; p++)
            for (int st = 1; st <= n; st++)
                for (int end = 1; end <= n; end++)
                    w[st][end] = Math.min(w[st][end], w[st][p] + w[p][end]);

        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (w[i][j] != INF)
                    res[w[i][j]]++;

        return IntStream.range(0, n).map(i -> res[i + 1]).toArray();
    }
}
