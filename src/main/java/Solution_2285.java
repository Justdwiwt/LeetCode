package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] arr = new int[n];
        Arrays.stream(roads).forEach(road -> {
            arr[road[0]]++;
            arr[road[1]]++;
        });
        Arrays.sort(arr);
        return IntStream.range(0, n).mapToLong(i -> (long) (i + 1) * arr[i]).sum();
    }
}
