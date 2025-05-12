package main.java;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2598 {
    public int findSmallestInteger(int[] nums, int value) {
        return Arrays.stream(nums)
                .map(num -> (num % value + value) % value)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .flatMapToInt(e -> IntStream.iterate(e.getKey(), i -> i + value).limit(e.getValue()))
                .sorted()
                .reduce(-1, (i, j) -> i + 1 != j ? i : j) + 1;
    }
}
