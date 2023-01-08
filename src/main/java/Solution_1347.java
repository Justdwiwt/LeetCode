package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1347 {
    public int minSteps(String s, String t) {
        int[] hash = new int[26];
        IntStream.range(0, s.length()).forEach(i -> {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        });
        return Arrays.stream(hash).filter(i -> i > 0).sum();
    }
}
