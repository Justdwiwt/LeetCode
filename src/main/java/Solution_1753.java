package main.java;

import java.util.Arrays;

public class Solution_1753 {
    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        return nums[0] + nums[1] <= nums[2] ? nums[0] + nums[1] : maximumScore(nums[0] - 1, nums[1] - 1, nums[2]) + 1;
    }
}
