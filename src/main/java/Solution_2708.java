package main.java;

public class Solution_2708 {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        long ans = nums[0];
        if (n == 1) return ans;
        long f0 = 0, f1 = 0;
        for (int num : nums) {
            if (num > 0) {
                f0 = Math.min(f0 * num, f0);
                f1 = f1 == 0 ? num : Math.max(f1 * num, f1);
            }
            if (num < 0) {
                long tmp = f0;
                f0 = f1 == 0 ? Math.min(num, f0)
                        : Math.min(f1 * num, f0);
                f1 = Math.max(tmp * num, f1);
            }
            ans = Math.max(f1, ans);
        }
        return ans;
    }
}
