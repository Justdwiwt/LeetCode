package main.java;

public class Solution_2447 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % k != 0) continue;
            int now = 0;
            for (int j = i; j < n; j++) {
                now = gcd(now, nums[j]);
                if (now == k) ans++;
            }
        }
        return ans;
    }
}
