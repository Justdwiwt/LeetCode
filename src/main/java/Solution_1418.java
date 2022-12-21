package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> head = orders.stream()
                .map(o -> o.get(2))
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(() -> Stream.of("Table").collect(Collectors.toList())));

        return orders.stream()
                .collect(Collectors.groupingBy(o -> Integer.parseInt(o.get(1)), Collectors.groupingBy(o -> o.get(2), Collectors.counting())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> head.stream()
                        .skip(1)
                        .map(food -> entry.getValue().getOrDefault(food, 0L).toString())
                        .collect(Collectors.toCollection(() -> Stream.of(entry.getKey().toString()).collect(Collectors.toList()))))
                .collect(Collectors.toCollection(() -> Stream.of(head).collect(Collectors.toList())));
    }
}
