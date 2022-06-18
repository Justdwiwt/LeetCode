package main.java;

import java.util.Arrays;

public class Solution_2255 {
    public int countPrefixes(String[] words, String s) {
        return (int) Arrays.stream(words)
                .filter(s::startsWith)
                .count();
    }
}
