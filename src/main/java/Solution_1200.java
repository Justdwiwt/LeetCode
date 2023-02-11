package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = IntStream.range(1, arr.length).map(i -> arr[i] - arr[i - 1]).min().orElse(Integer.MAX_VALUE);
        return IntStream.range(1, arr.length).filter(i -> arr[i] - arr[i - 1] == diff).mapToObj(i -> Arrays.asList(arr[i - 1], arr[i])).collect(Collectors.toList());
    }
}
