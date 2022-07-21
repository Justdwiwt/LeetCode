package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution_2103 {
    public int countPoints(String rings) {
        HashMap<Integer, Set<Character>> m = new HashMap<>();
        for (int i = 0; i + 1 < rings.length(); i += 2)
            m.computeIfAbsent(rings.charAt(i + 1) - '0', k -> new HashSet<>()).add(rings.charAt(i));

        return (int) m
                .values()
                .stream()
                .filter(colors -> colors.size() == 3)
                .count();
    }
}
