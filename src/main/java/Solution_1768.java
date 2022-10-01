package main.java;

import java.util.stream.IntStream;

public class Solution_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.min(word1.length(), word2.length());
        IntStream.range(0, length).forEach(i -> sb.append(word1.charAt(i)).append(word2.charAt(i)));
        return sb.append(word1.substring(length)).append(word2.substring(length)).toString();
    }
}
