package main.java;

import java.util.stream.IntStream;

public class Solution_1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        return IntStream.range(0, words.length - 2)
                .filter(i -> first.equals(words[i]) && second.equals(words[i + 1]))
                .mapToObj(i -> words[i + 2])
                .toArray(String[]::new);
    }
}
