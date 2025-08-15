package main.java;

import java.util.Arrays;

public class Solution_2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[nums.length];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (Math.abs(nums[j] - nums[i]) <= target && f[j] != -1)
                    f[i] = Math.max(f[j] + 1, f[i]);
        return f[n - 1];
    }
}
