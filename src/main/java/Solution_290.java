package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Solution_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        Map<Object, Integer> map = new HashMap<>();
        return IntStream.range(0, strings.length).allMatch(i -> Objects.equals(map.put(strings[i], i), map.put(pattern.charAt(i), i)));
    }
}
