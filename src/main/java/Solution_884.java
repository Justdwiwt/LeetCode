package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_884 {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream((A + " " + B).split(" ")).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        return map.keySet().stream().filter(s -> map.get(s) == 1).toArray(String[]::new);
    }
}
