package main.java;

import java.util.Arrays;

public class Solution_2997 {
    public int minOperations(int[] nums, int k) {
        k ^= Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        return Integer.bitCount(k);
    }
}
