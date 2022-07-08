package main.java;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        return Stream.of(Arrays.stream(nums).filter(e -> e < pivot),
                        Arrays.stream(nums).filter(e -> e == pivot),
                        Arrays.stream(nums).filter(e -> e > pivot))
                .flatMapToInt(x -> x)
                .toArray();
    }
}
