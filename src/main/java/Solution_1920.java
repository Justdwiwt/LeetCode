package main.java;

import java.util.Arrays;

public class Solution_1920 {
    public int[] buildArray(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> nums[num])
                .toArray();
    }
}
