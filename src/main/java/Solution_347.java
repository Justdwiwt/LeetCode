package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
