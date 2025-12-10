package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream.range(0, words.length).filter(i -> words[i].indexOf(x) >= 0).boxed().collect(Collectors.toList());
    }
}
