package main.java;

import java.util.*;

public class Solution_2768 {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        int[][] ts = new int[][]{{0, 0}, {-1, 0}, {0, -1}, {-1, -1}};
        Map<List<Integer>, Integer> map = new HashMap<>();
        long[] res = new long[5];
        Arrays.stream(coordinates).forEach(num -> Arrays.stream(ts).forEach(t -> {
            List<Integer> a = new ArrayList<>();
            a.add(num[0] + t[0]);
            a.add(num[1] + t[1]);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }));
        map.keySet().stream().filter(l -> l.get(0) >= 0 && l.get(0) < m - 1 && l.get(1) >= 0 && l.get(1) < n - 1).forEach(l -> res[map.get(l)]++);
        res[0] = (long) (m - 1) * (n - 1) - Arrays.stream(res).sum();
        return res;
    }
}
