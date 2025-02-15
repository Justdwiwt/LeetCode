package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_2506 {
    public int similarPairs(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w.chars().reduce(0, (mask, ch) -> mask | 1 << ch - 'a'), Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .map(v -> v * (v - 1) / 2)
                .sum();
    }
}
