package main.java;

import java.util.Arrays;

public class Solution_2047 {
    public int countValidWords(String sentence) {
        String[] arr = sentence.trim().split("\\s+");
        return (int) Arrays.stream(arr)
                .filter(str -> str.matches("[a-z]*([a-z]-[a-z])?[a-z]*[!.,]?"))
                .count();
    }
}
