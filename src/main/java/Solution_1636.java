package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1636 {
    public int[] frequencySort(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().thenComparing(Map.Entry.<Integer, Long>comparingByKey().reversed()))
                .flatMapToInt(e -> IntStream.generate(e::getKey).limit(e.getValue()))
                .toArray();
    }
}
