package main.java;

import java.util.stream.IntStream;

public class Solution_2490 {
    public boolean isCircularSentence(String sentence) {
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1) && IntStream.range(0, sentence.length())
                .filter(i -> sentence.charAt(i) == ' ')
                .noneMatch(i -> sentence.charAt(i - 1) != sentence.charAt(i + 1));
    }
}
