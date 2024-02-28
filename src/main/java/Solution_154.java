package main.java;

import java.util.Arrays;

public class Solution_154 {
    public int findMin(int[] nums) {
        return Arrays
                .stream(nums)
                .min()
                .orElse(0);
    }
}
