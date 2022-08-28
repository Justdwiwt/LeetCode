package main.java;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Solution_1941 {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> m = new HashMap<>();

        IntStream.range(0, s.length())
                .forEach(i -> m.compute(s.charAt(i), (k, v) -> v == null ? 1 : ++v));

        return m.values()
                .stream()
                .allMatch(frequency -> frequency.equals(m.get(s.charAt(0))));
    }
}
