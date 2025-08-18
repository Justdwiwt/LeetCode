package main.java;

import java.util.stream.IntStream;

public class Solution_2778 {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        return IntStream.rangeClosed(1, nums.length).filter(i -> n % i == 0).map(i -> nums[i - 1] * nums[i - 1]).sum();
    }
}
