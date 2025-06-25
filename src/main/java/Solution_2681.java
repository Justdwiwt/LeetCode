package main.java;

import java.util.Arrays;

public class Solution_2681 {
    final int MOD = (int) (1e9 + 7);

    public int sumOfPower(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0L, preSum = 0L;
        for (int num : nums) {
            ans = (ans + (long) num * num % MOD * (preSum + num)) % MOD;
            preSum = (preSum * 2 + num) % MOD;
        }
        return (int) ans;
    }
}
