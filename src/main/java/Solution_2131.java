package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> m = new HashMap<>();
        Arrays.stream(words).forEach(word -> m.put(word, m.getOrDefault(word, 0) + 1));
        int maxLength = 0;
        boolean hasOdd = false;
        for (String key : m.keySet()) {
            String reverse = new String(new char[]{key.charAt(1), key.charAt(0)});
            if (key.equals(reverse))
                if (m.get(key) % 2 == 1) {
                    hasOdd = true;
                    maxLength += (m.get(key) - 1) * 2;
                } else maxLength += m.get(key) * 2;
            else if (m.containsKey(reverse)) {
                int notEqualCount = Math.min(m.get(key), m.get(reverse));
                maxLength += 2 * notEqualCount;
            }
        }
        return hasOdd ? maxLength + 2 : maxLength;
    }
}
