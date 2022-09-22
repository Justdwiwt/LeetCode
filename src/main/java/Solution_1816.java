package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_1816 {
    public String truncateSentence(String s, int k) {
        return Arrays.stream(s.split(" "))
                .limit(k)
                .collect(Collectors.joining(" "));
    }
}
