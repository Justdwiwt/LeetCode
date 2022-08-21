package main.java;

import java.util.Arrays;

public class Solution_1967 {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(word::contains).count();
    }
}
