package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution_1859 {
    public String sortSentence(String s) {
        return Arrays.stream(s.split(" "))
                .sorted(Comparator.comparingInt(o -> o.charAt(o.length() - 1)))
                .map(e -> e.substring(0, e.length() - 1))
                .collect(Collectors.joining(" "));
    }
}
