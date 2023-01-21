package main.java;

import java.util.stream.IntStream;

public class Solution_1304 {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        IntStream.range(0, n / 2).forEach(i -> {
            nums[i] = i + 1;
            nums[n - i - 1] = -(i + 1);
        });
        return nums;
    }
}
