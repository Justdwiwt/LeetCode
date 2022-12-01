package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int t = arr[1] - arr[0];
        return IntStream.range(2, arr.length).noneMatch(i -> arr[i] - arr[i - 1] != t);
    }
}
