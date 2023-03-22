package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_1001 {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, 0}, {0, -1}, {1, 1}, {1, 0}, {1, -1}};
        Set<Long> points = new HashSet<>();
        Map<Integer, Integer> rows = new HashMap<>(),
                cols = new HashMap<>(),
                tr1 = new HashMap<>(),
                tr2 = new HashMap<>();
        Arrays.stream(lamps).forEach(lamp -> {
            int row = lamp[0], col = lamp[1];
            long idx = (long) row * n + col;
            if (points.add(idx)) {
                rows.put(row, rows.getOrDefault(row, 0) + 1);
                cols.put(col, cols.getOrDefault(col, 0) + 1);
                tr1.put(row - col, tr1.getOrDefault(row - col, 0) + 1);
                tr2.put(row + col, tr2.getOrDefault(row + col, 0) + 1);
            }
        });
        int N = queries.length;
        int[] res = new int[N];
        IntStream.range(0, queries.length).forEach(i -> {
            int x = queries[i][0], y = queries[i][1];
            res[i] = rows.containsKey(x) || cols.containsKey(y) || tr1.containsKey(x - y) || tr2.containsKey(x + y) ? 1 : 0;
            Arrays.stream(dirs).forEach(dir -> {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    long idx = (long) newX * n + newY;
                    if (!points.contains(idx)) return;
                    points.remove(idx);
                    decrease(rows, newX);
                    decrease(cols, newY);
                    decrease(tr1, newX - newY);
                    decrease(tr2, newX + newY);
                }
            });
        });
        return res;
    }

    private void decrease(Map<Integer, Integer> map, int idx) {
        int val = map.get(idx);
        if (val == 1) map.remove(idx);
        else map.put(idx, val - 1);
    }
}
