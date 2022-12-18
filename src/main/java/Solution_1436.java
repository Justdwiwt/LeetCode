package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_1436 {
    public static String destCity(List<List<String>> paths) {
        Map<String, Integer> map = paths.stream().collect(Collectors.toMap(list -> list.get(0), list -> 1, (a, b) -> b));

        return paths.stream()
                .filter(list -> map.get(list.get(1)) == null)
                .findFirst()
                .map(list -> list.get(1))
                .orElse(null);
    }
}
