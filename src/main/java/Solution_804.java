package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] diff = {".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String sb = IntStream.range(0, word.length()).mapToObj(i -> diff[word.charAt(i) - 'a']).collect(Collectors.joining());
            set.add(sb);
        }
        return set.size();
    }
}
