package main.java;

import java.util.Arrays;

public class Solution_2114 {
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(e -> e.split(" ").length)
                .max()
                .getAsInt();
    }
}
