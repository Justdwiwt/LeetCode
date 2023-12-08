package main.java;

import java.util.stream.IntStream;

public class Solution_283 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) nums[idx++] = nums[i];
        IntStream.range(idx, nums.length).forEach(i -> nums[i] = 0);
    }
}
