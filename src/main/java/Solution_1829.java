package main.java;

import java.util.stream.IntStream;

public class Solution_1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        int[] res = new int[len];
        IntStream.range(0, len).forEach(i -> {
            if (i > 0) nums[i] ^= nums[i - 1];
            res[len - i - 1] = nums[i] ^ (int) (Math.pow(2, maximumBit) - 1);
        });
        return res;
    }
}
