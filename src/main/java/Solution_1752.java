package main.java;

import java.util.stream.IntStream;

public class Solution_1752 {
    public boolean check(int[] nums) {
        return (int) IntStream.range(0, nums.length)
                .filter(i -> nums[i] > nums[(i + 1) % nums.length])
                .count() <= 1;
    }
}
