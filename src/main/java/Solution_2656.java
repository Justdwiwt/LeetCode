package main.java;

import java.util.Arrays;

public class Solution_2656 {
    public int maximizeSum(int[] nums, int k) {
        return (2 * Arrays.stream(nums).max().orElse(0) + k - 1) * k / 2;
    }
}
