package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> freqByWord1 = new HashMap<>();
        Map<String, Integer> freqByWord2 = new HashMap<>();

        Arrays.stream(words1).forEach(word -> freqByWord1.put(word, (freqByWord1.getOrDefault(word, 0) + 1)));
        Arrays.stream(words2).forEach(word -> freqByWord2.put(word, (freqByWord2.getOrDefault(word, 0) + 1)));

        return (int) freqByWord1
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1 && freqByWord2.getOrDefault(entry.getKey(), 0) == 1)
                .count();
    }
}
