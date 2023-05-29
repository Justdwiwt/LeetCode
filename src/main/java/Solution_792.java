package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_792 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        int res = 0;
        for (String word : words) {
            if (map.get(word) != null && isMatch(s, word)) res += map.get(word);
            map.remove(word);
        }
        return res;
    }

    private boolean isMatch(String s, String t) {
        int m = s.length();
        int n = t.length();
        int j = 0;
        for (int i = 0; i < m && j < n; i++)
            if (s.charAt(i) == t.charAt(j)) j++;
        return j == n;
    }
}
