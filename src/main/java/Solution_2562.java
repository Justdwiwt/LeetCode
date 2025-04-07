package main.java;

public class Solution_2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i != j) {
                ans += Long.parseLong(String.valueOf(nums[i]) + nums[j]);
                continue;
            }
            ans += nums[i];
        }
        return ans;
    }
}
