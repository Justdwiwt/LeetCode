package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arrays = new int[101];
        Arrays.stream(nums).forEach(num -> arrays[num] += 1);
        IntStream.range(1, arrays.length).forEach(i -> arrays[i] += arrays[i - 1]);
        IntStream.range(0, nums.length).forEach(i -> nums[i] = nums[i] != 0 ? arrays[nums[i] - 1] : 0);
        return nums;
    }
}
