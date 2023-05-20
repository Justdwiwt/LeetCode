package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.stream(words).forEach(word -> IntStream.range(1, word.length()).mapToObj(word::substring).forEach(set::remove));
        return set.stream().mapToInt(word -> word.length() + 1).sum();
    }
}
