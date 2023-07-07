package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(s -> dictionary.stream().filter(s::startsWith).min(Comparator.comparingInt(String::length)).orElse(s))
                .collect(Collectors.joining(" "));
    }
}
