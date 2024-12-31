package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2451 {
    public String Get(String src) {
        return IntStream.range(1, src.length())
                .mapToObj(i -> String.valueOf(src.charAt(i) - src.charAt(i - 1) + ','))
                .collect(Collectors.joining());
    }

    public String oddString(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words)
                .map(this::Get)
                .forEach(tmp -> map.put(tmp, map.getOrDefault(tmp, 0) + 1));

        return Arrays.stream(words)
                .filter(word -> map.get(Get(word)) == 1)
                .findFirst()
                .orElse("");
    }
}
