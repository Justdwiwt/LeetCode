package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = IntStream
                .range(0, nums.length)
                .boxed()
                .collect(Collectors.toMap(i -> nums[i], i -> i, (a, b) -> b));

        Arrays.stream(operations).forEach(operation -> {
            int k = map.get(operation[0]);
            map.put(operation[1], k);
            nums[k] = operation[1];
        });

        return nums;
    }
}
