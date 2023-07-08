package main.java;

import java.util.stream.IntStream;

public class Solution_645 {
    public int[] findErrorNums(int[] nums) {
        int[] set = new int[2];
        int[] newNums = new int[nums.length];
        IntStream.range(0, nums.length).forEach(i -> {
            if (newNums[nums[i] - 1] != 0) set[0] = nums[i];
            newNums[nums[i] - 1] = nums[i];
        });
        IntStream.range(0, newNums.length).filter(i -> newNums[i] == 0).forEach(i -> set[1] = i + 1);
        return set;
    }
}
