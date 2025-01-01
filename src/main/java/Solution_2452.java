package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        return Stream.of(queries)
                .filter(s -> Stream.of(dictionary)
                        .anyMatch(t -> IntStream.range(0, queries[0].length())
                                .filter(i -> s.charAt(i) != t.charAt(i))
                                .count() < 3))
                .collect(Collectors.toList());
    }
}
