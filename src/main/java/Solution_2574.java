package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2574 {
    public int[] leftRightDifference(int[] nums) {
        return IntStream.range(0, nums.length)
                .map(i -> Math.abs(Arrays.stream(Arrays.copyOfRange(nums, 0, i)).sum() -
                        Arrays.stream(Arrays.copyOfRange(nums, i + 1, nums.length + 1)).sum()))
                .toArray();
    }
}
