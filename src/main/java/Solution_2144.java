package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2144 {
    public int minimumCost(int[] cost) {
        int[] arr = Arrays.stream(cost)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        return IntStream.range(0, arr.length)
                .filter(i -> i % 3 != 2)
                .map(i -> arr[i])
                .sum();
    }
}
