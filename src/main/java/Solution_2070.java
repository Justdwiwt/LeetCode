package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        NavigableMap<Integer, Integer> tm = new TreeMap<>();

        Arrays.stream(items).forEach(item -> {
            if (tm.containsKey(item[0])) tm.put(item[0], Math.max(item[1], tm.get(item[0])));
            else tm.put(item[0], item[1]);
        });

        int maxSoFar = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            maxSoFar = Math.max(maxSoFar, entry.getValue());
            entry.setValue(maxSoFar);
        }

        IntStream.range(0, queries.length).forEach(i -> {
            Map.Entry<Integer, Integer> entry = tm.floorEntry(queries[i]);
            queries[i] = entry == null ? 0 : entry.getValue();
        });

        return queries;
    }
}
