package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_782 {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int[] x = new int[n], y = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == 1) x[i] |= 1 << j;
            Integer integer = m.getOrDefault(x[i], 0);
            m.put(x[i], integer + 1);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[j][i] == 1) y[i] |= 1 << j;
        IntStream.range(0, n).forEach(i -> {
            Integer integer = f.getOrDefault(y[i], 0);
            f.put(y[i], integer + 1);
        });
        int exChangEx = exChangEx(m, x);
        int exChangEy = exChangEx(f, y);
        if (exChangEy == -1 || exChangEx == -1) return -1;
        return exChangEx + exChangEy;
    }

    private int exChangEx(Map<Integer, Integer> m, int[] x) {
        int size = m.size();
        if (size != 2) return -1;
        int max = 0, min = 10000, first = 0, res, n = x.length;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            Integer value = entry.getValue();
            if (max < value) first = entry.getKey();
            max = Math.max(value, max);
            min = Math.min(value, min);
        }
        if (max - min > 1 || m.get(first ^ ((1 << n) - 1)) == null) return -1;
        first = max == min ? x[0] : first;
        res = getLRes(x, first, n);
        if (max == min) res = Math.min(getLRes(x, first ^ ((1 << n) - 1), n), res);
        return res >> 1;
    }

    private int getLRes(int[] x, int first, int n) {
        int lres = 0;
        for (int i = 0; i < n; i++)
            if ((i & 1) == 0) {
                if (first != x[i]) lres++;
            } else if (first == x[i]) lres++;
        return lres;
    }
}
