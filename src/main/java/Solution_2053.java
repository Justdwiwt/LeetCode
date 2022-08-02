package main.java;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution_2053 {
    public String kthDistinct(String[] arr, int k) {
        return Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(1L))
                .map(Map.Entry::getKey)
                .skip(k - 1)
                .findFirst()
                .orElse("");
    }
}
