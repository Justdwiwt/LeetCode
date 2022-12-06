package main.java;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        AtomicInteger atomK = new AtomicInteger(k);
        return (int) Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(cnt -> atomK.addAndGet((int) -cnt) < 0)
                .count();
    }
}
