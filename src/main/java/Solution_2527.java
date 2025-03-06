package main.java;

import java.util.Arrays;

public class Solution_2527 {
    public int xorBeauty(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
