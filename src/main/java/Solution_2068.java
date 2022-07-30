package main.java;

import java.util.Arrays;

public class Solution_2068 {
    public boolean checkAlmostEquivalent(String w1, String w2) {
        int[] cnt = new int[26];
        w1.chars().forEach(c -> cnt[c - 'a']++);
        w2.chars().forEach(c -> cnt[c - 'a']--);
        return Arrays.stream(cnt).allMatch(c -> Math.abs(c) <= 3);
    }
}
