package main.java;

import java.util.Arrays;

public class Solution_2419 {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int res = 0;
        int continuousMax = 0;
        for (int num : nums) {
            continuousMax = num == max ? continuousMax + 1 : 0;
            res = Math.max(res, continuousMax);
        }
        return res;
    }
}
