package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.stream(arr).forEach(elem -> m.put(elem, m.getOrDefault(elem, 0) + 1));
        return m.size() == new HashSet<>(m.values()).size();
    }
}
