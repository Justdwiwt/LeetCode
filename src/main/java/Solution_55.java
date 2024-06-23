package main.java;

import java.util.stream.IntStream;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int lastIndex = nums.length - 1;
        return IntStream
                .range(0, lastIndex)
                .reduce(1, (len, i) -> len <= 0 ? len : Math.max(len - 1, nums[i])) > 0;
    }
}
