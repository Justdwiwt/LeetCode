package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] ss = paragraph.replaceAll("[^a-zA-Z]+", " ").toLowerCase().split(" ");
        Map<String, Integer> map = Arrays.stream(banned).collect(Collectors.toMap(s -> s, s -> -10000, (a, b) -> b));
        String res = "";
        int max = 0;
        for (String s : ss) {
            int i = map.getOrDefault(s, 0) + 1;
            if (i > max) {
                res = s;
                max = i;
            }
            map.put(s, i);
        }
        return res;
    }
}
