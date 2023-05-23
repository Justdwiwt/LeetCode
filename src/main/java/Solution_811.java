package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(cpdomains).map(c -> c.split(" ")).forEach(s -> {
            int a = Integer.parseInt(s[0]);
            inc(map, s[1], a);
            IntStream.range(0, s[1].length()).filter(j -> s[1].charAt(j) == '.').forEach(j -> inc(map, s[1].substring(j + 1), a));
        });
        return map.keySet().stream().map(s -> map.get(s) + " " + s).collect(Collectors.toList());
    }

    private void inc(Map<String, Integer> map, String s, int a) {
        map.put(s, map.getOrDefault(s, 0) + a);
    }
}
