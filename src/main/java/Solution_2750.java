package main.java;

public class Solution_2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long ans = 1, mod = 1000000007;
        int pre = -1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 1) {
                if (pre != -1) ans = ans * (long) (i - pre) % mod;
                pre = i;
            }
        return pre == -1 ? 0 : (int) ans;
    }
}
