package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        return Stream.concat(Arrays.stream(items1), Arrays.stream(items2))
                .collect(Collectors.toMap(item -> item[0], item -> item[1], Integer::sum, TreeMap::new))
                .entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
