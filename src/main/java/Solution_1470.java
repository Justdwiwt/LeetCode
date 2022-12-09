package main.java;

import java.util.stream.IntStream;

public class Solution_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        IntStream.range(0, n).forEach(i -> {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        });
        return res;
    }
}
