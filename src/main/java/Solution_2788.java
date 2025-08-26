package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        return words.stream()
                .map(e -> e.split("\\" + String.valueOf(separator)))
                .flatMap(Arrays::stream)
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());
    }
}
