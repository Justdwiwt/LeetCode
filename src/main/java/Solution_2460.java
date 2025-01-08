package main.java;

import java.util.stream.IntStream;

public class Solution_2460 {
    public int[] applyOperations(int[] nums) {
        IntStream.range(1, nums.length).filter(i -> nums[i - 1] == nums[i]).forEach(i -> {
            nums[i - 1] = 2 * nums[i];
            nums[i] = 0;
        });
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int num : nums)
            if (num > 0) ans[idx++] = num;
        return ans;
    }
}
