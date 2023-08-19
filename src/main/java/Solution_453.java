package main.java;

import java.util.Arrays;

public class Solution_453 {
    public int minMoves(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).min().orElse(0);
        return sum - min * nums.length;
    }
}
