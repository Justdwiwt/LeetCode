package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_2080 {
    static class RangeFreqQuery {
        private final Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            IntStream.range(0, arr.length).forEach(i -> {
                map.putIfAbsent(arr[i], new TreeMap<>());
                map.get(arr[i]).put(i, map.get(arr[i]).size());
            });
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) return 0;

            Map.Entry<Integer, Integer> floor = map.get(value).floorEntry(right);
            Map.Entry<Integer, Integer> ceil = map.get(value).ceilingEntry(left);

            return (floor == null || ceil == null) ? 0 : floor.getValue() - ceil.getValue() + 1;
        }
    }
}
