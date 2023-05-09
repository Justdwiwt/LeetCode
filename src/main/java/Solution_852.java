package main.java;

import java.util.stream.IntStream;

public class Solution_852 {
    public int peakIndexInMountainArray(int[] arr) {
        return IntStream.range(0, arr.length - 1)
                .filter(i -> arr[i] > arr[i + 1])
                .findFirst()
                .orElse(0);
    }
}
