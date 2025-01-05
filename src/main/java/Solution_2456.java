package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> sumMap = new HashMap<>();
        IntStream.range(0, views.length).forEach(i -> sumMap.put(creators[i], sumMap.getOrDefault(creators[i], 0L) + views[i]));
        long maxSumView = sumMap.values().stream().max(Long::compareTo).orElse(0L);
        sumMap.forEach((key, value) -> sumMap.put(key, value == maxSumView ? -1L : Long.MAX_VALUE));
        Map<String, String> idMap = new HashMap<>();
        IntStream.range(0, views.length).forEach(i -> {
            long maxView = sumMap.get(creators[i]);
            if (maxView < views[i] || (maxView == views[i] && ids[i].compareTo(idMap.get(creators[i])) < 0)) {
                idMap.put(creators[i], ids[i]);
                sumMap.put(creators[i], (long) views[i]);
            }
        });
        return idMap.entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }
}
