package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2301 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> replacements = new HashMap<>();
        Arrays.stream(mappings).forEach(mapping -> {
            replacements.putIfAbsent(mapping[0], new HashSet<>());
            replacements.get(mapping[0]).add(mapping[1]);
        });
        int n = s.length(), m = sub.length();
        int maxStart = n - m;
        return IntStream.rangeClosed(0, maxStart).anyMatch(i -> canMatch(s, sub, i, replacements));
    }

    public boolean canMatch(String s, String sub, int start, Map<Character, Set<Character>> replacements) {
        int m = sub.length();
        for (int i = 0; i < m; i++) {
            char c1 = s.charAt(i + start), c2 = sub.charAt(i);
            if (c1 == c2) continue;
            Set<Character> set = replacements.getOrDefault(c2, new HashSet<>());
            if (!set.contains(c1)) return false;
        }
        return true;
    }
}
