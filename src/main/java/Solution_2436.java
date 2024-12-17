package main.java;

public class Solution_2436 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minimumSplits(int[] nums) {
        int n = nums.length, i = 0, ans = 0;
        while (i < n) {
            ans++;
            int gcd = nums[i++];
            while (i < n && (gcd = gcd(gcd, nums[i])) > 1) i++;
        }
        return ans;
    }
}
