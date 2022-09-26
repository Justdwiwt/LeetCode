package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1791 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> m = new HashMap<>();
        IntStream.range(0, edges.length).forEach(i -> {
            m.put(edges[i][0], m.getOrDefault(edges[i][0], 0) + 1);
            m.put(edges[i][1], m.getOrDefault(edges[i][1], 0) + 1);
        });
        return m
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == edges.length)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
