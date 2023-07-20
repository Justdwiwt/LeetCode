package main.java;

import java.util.stream.IntStream;

public class Solution_567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] word = new int[26];
        IntStream.range(0, s1.length()).forEach(i -> {
            char c = s1.charAt(i);
            word[c - 'a']++;
        });
        for (int i = 0, j = 0; i < s2.length(); i++) {
            word[s2.charAt(i) - 'a']--;
            while (word[s2.charAt(i) - 'a'] < 0) {
                word[s2.charAt(j) - 'a']++;
                j++;
            }
            if (i - j + 1 == s1.length()) return true;
        }
        return false;
    }
}
