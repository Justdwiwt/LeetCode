package main.java;

import java.util.stream.IntStream;

public class Solution_2772 {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length, sum = 0;
        int[] f = new int[n + 1];
        f[0] = nums[0];
        IntStream.range(1, n).forEach(i -> f[i] = nums[i] - nums[i - 1]);
        for (int i = 0; i < n; i++) {
            if (f[i] == 0) continue;
            if (f[i] < 0 || i + k > n) return false;
            f[i + k] += f[i];
        }
        return true;
    }
}
