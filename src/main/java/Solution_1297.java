package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1297 {
    private boolean checkMaxLetter(String s, int maxLetter) {
        Map<Character, Integer> m = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            m.put(c, m.getOrDefault(c, 0) + 1);
            if (m.size() > maxLetter) return false;
        }
        return true;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        Map<String, Integer> m = new HashMap<>();
        IntStream.rangeClosed(0, s.length() - minSize).mapToObj(i -> s.substring(i, i + minSize)).forEach(t -> m.put(t, m.getOrDefault(t, 0) + 1));
        for (String t : m.keySet()) if (m.get(t) > max && checkMaxLetter(t, maxLetters)) max = m.get(t);
        return max;
    }
}
