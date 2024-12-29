package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2449 {
    public long makeSimilar(int[] nums, int[] target) {
        if (nums.length != target.length) return Long.MAX_VALUE;

        Integer[] sortedNums = Arrays.stream(nums).boxed()
                .sorted(Comparator.comparingInt((Integer n) -> n % 2).thenComparingInt(n -> n))
                .toArray(Integer[]::new);

        Integer[] sortedTarget = Arrays.stream(target).boxed()
                .sorted(Comparator.comparingInt((Integer n) -> n % 2).thenComparingInt(n -> n))
                .toArray(Integer[]::new);

        return IntStream.range(0, nums.length).mapToLong(i -> Math.abs(sortedNums[i] - sortedTarget[i])).sum() / 4;
    }
}
