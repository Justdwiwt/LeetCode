package main.java;

import java.util.List;
import java.util.stream.Collectors;

public class Solution_2828 {
    public boolean isAcronym(List<String> words, String s) {
        String sb = words.stream().map(word -> word.substring(0, 1)).collect(Collectors.joining());
        return sb.equals(s);
    }
}
