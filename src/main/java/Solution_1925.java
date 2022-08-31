package main.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1925 {
    public int countTriples(int n) {
        Map<Integer, Integer> map = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toMap(i -> i * i, i -> 1, (a, b) -> b));

        return map
                .keySet()
                .stream()
                .mapToInt(a -> map.keySet().stream().mapToInt(b -> map.getOrDefault(a + b, 0)).sum())
                .sum();
    }
}
