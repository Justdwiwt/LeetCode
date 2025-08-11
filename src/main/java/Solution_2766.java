package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int n = moveFrom.length;
        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, (a, b) -> b));

        IntStream.range(0, n).forEach(i -> {
            int m = map.getOrDefault(moveFrom[i], 0);
            map.put(moveFrom[i], 0);
            map.put(moveTo[i], map.getOrDefault(moveTo[i], 0) + m);
        });

        return map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());
    }
}
