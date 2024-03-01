package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_151 {
    public String reverseWords(String s) {
        List<String> str = Arrays.stream(s.trim().split("\\s+")).collect(Collectors.toList());
        Collections.reverse(str);
        return String.join(" ", str);
    }
}
