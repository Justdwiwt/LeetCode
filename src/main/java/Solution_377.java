package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        IntStream.rangeClosed(1, n).forEach(i -> f[i][0] = 1);
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= target; j++)
                for (int z = 1; z <= i; z++)
                    if (j < nums[z - 1]) f[i][j] = f[i - 1][j];
                    else f[i][j] += f[i][j - nums[z - 1]];
        return f[n][target];
    }
}
