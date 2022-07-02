package main.java;

import java.util.Arrays;

public class Solution_2185 {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words)
                .filter(s -> s.startsWith(pref))
                .count();
    }
}
