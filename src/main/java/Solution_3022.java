package main.java;

public class Solution_3022 {
    public int minOrAfterOperations(int[] nums, int k) {
        int ans = 0, n = nums.length, mask = 0;
        for (int i = 29; i >= 0; i--) {
            int pre = Integer.MAX_VALUE, count = 0;
            for (int a : nums) {
                pre &= a;
                if ((pre >> i << i | mask) == ans) {
                    count++;
                    pre = Integer.MAX_VALUE;
                }
            }
            if (count == 0 || n - count > k) mask = ans |= 1 << i;
        }
        return ans;
    }
}
