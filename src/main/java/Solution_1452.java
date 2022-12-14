package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1452 {
    public List<Integer> peopleIndexes(List<List<String>> cs) {
        Map<Integer, HashSet<String>> map = IntStream.range(0, cs.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> new HashSet<>(cs.get(i))));
        return IntStream.range(0, cs.size())
                .filter(i -> map.entrySet()
                        .stream()
                        .noneMatch(e -> e.getKey() != i && e.getValue().size() > cs.get(i).size() && e.getValue().containsAll(cs.get(i))))
                .boxed()
                .collect(Collectors.toList());
    }
}
