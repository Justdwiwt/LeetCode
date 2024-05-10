package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_87 {
    Map<String, Map<String, Boolean>> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (hashCode(s1) != hashCode(s2)) return false;
        int len = s1.length();
        if (len <= 3) return true;

        if (map.containsKey(s1) && map.get(s1).containsKey(s2)) return map.get(s1).get(s2);
        for (int i = 1; i < len; i++) {
            String s1L = s1.substring(0, i);
            String s1R = s1.substring(i);
            if (isScramble(s1L, s2.substring(0, i)) && isScramble(s1R, s2.substring(i)) || isScramble(s1L, s2.substring(len - i)) && isScramble(s1R, s2.substring(0, len - i))) {
                map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, true);
                return true;
            }
        }
        map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, false);
        return false;
    }

    private int hashCode(String s) {
        return s.chars().map(c -> 1 << c - 'a').sum();
    }
}
