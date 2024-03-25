package main.java;

import java.util.Arrays;

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int count = 1;
        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 0) continue;
            if (nums[i + 1] - nums[i] == 1) {
                count++;
                if (count > max) max = count;
            } else count = 1;
        }
        return max;
    }
}
