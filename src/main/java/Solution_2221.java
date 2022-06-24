package main.java;

import java.util.stream.IntStream;

public class Solution_2221 {
    public int triangularSum(int[] nums) {
        for (int n = nums.length - 1; n > 0; --n)
            IntStream.range(0, n).forEach(i -> nums[i] = (nums[i] + nums[i + 1]) % 10);
        return nums[0];
    }
}
