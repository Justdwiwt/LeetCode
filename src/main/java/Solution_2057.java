package main.java;

import java.util.stream.IntStream;

public class Solution_2057 {
    public int smallestEqual(int[] nums) {
        return IntStream.range(0, nums.length)
                .filter(i -> i % 10 == nums[i])
                .findFirst()
                .orElse(-1);
    }
}
