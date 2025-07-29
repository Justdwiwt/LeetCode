package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        return (int) Arrays.stream(words).filter(str -> str.charAt(0) != str.charAt(1) && set.contains("" + str.charAt(1) + str.charAt(0))).count() / 2;
    }
}
