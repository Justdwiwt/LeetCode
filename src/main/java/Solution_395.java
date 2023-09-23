package main.java;

import java.util.stream.IntStream;

public class Solution_395 {
    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        int len = s.length();
        IntStream.range(0, len).forEach(i -> arr[s.charAt(i) - 'a']++);
        for (int i = 0; i < len; i++)
            if (arr[s.charAt(i) - 'a'] < k)
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(i + 1, len), k));
        return len;
    }
}
