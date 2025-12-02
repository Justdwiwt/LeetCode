package main.java;

import java.util.Arrays;

public class Solution_2932 {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length && nums[j] - nums[i] <= nums[i]; j++)
                result = Math.max(result, nums[i] ^ nums[j]);
        return result;
    }
}
