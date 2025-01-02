package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2453 {
    public int destroyTargets(int[] nums, int space) {
        return Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.groupingBy(n -> n % space))
                .values()
                .stream()
                .max(Comparator.comparingInt((List<Integer> n) -> n.size()).thenComparing(n -> -n.get(0)))
                .map(n -> n.get(0))
                .orElse(0);
    }
}
