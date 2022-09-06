package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_1897 {
    public boolean makeEqual(String[] words) {
        return Arrays.stream(words)
                .flatMapToInt(String::chars)
                .boxed()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .values()
                .stream()
                .allMatch(v -> v % words.length == 0);
    }
}
