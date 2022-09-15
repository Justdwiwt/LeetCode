package main.java;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .mapToObj(i -> Math.abs(i - start))
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new))
                .get(0);
    }
}
