package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2248 {
    public List<Integer> intersection(int[][] nums) {
        int[] cnt = new int[1001];
        Arrays.stream(nums).forEach(e -> Arrays.stream(e).forEach(n -> cnt[n]++));
        return IntStream.range(0, cnt.length)
                .filter(n -> cnt[n] == nums.length)
                .boxed()
                .collect(Collectors.toList());
    }
}
