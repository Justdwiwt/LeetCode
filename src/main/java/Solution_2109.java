package main.java;

import java.util.stream.IntStream;

public class Solution_2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        IntStream.range(0, spaces.length).forEach(i -> sb.insert(spaces[i] + i, " "));
        return sb.toString();
    }
}
