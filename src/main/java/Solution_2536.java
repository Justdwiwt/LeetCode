package main.java;

import java.util.Arrays;

public class Solution_2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] d = new int[n][n];
        Arrays.stream(queries).forEach(query -> {
            int x1 = query[0], y1 = query[1];
            int x2 = query[2], y2 = query[3];
            d[x1][y1]++;
            if (y2 + 1 < n) d[x1][y2 + 1]--;
            if (x2 + 1 < n) d[x2 + 1][y1]--;
            if (x2 + 1 < n && y2 + 1 < n) d[x2 + 1][y2 + 1]++;
        });

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) d[i][j] += d[i - 1][j];
                if (j - 1 >= 0) d[i][j] += d[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0) d[i][j] -= d[i - 1][j - 1];
            }
        return d;
    }
}
