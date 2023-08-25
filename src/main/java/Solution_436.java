package main.java;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> tm = IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> intervals[i][0], i -> i, (a, b) -> b, TreeMap::new));
        int[] res = new int[n];
        IntStream.range(0, n).forEach(i -> {
            int end = intervals[i][1];
            Integer start = tm.ceilingKey(end);
            res[i] = start == null ? -1 : tm.get(start);
        });
        return res;
    }
}
