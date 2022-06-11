package main.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        return IntStream.range(0, senders.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> senders[i],
                        Collectors.mapping(i -> messages[i],
                                Collectors.mapping(s -> s.chars().filter(ch -> ch == ' ').count() + 1,
                                        Collectors.summingLong(Long::longValue)))))
                .entrySet()
                .stream()
                .max(Map.Entry.<String, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .get();
    }
}
