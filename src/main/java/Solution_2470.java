package main.java;

public class Solution_2470 {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int min = 1;
            for (int j = i; j < n; j++) {
                min = min * nums[j] / gcd(min, nums[j]);
                if (min > k) break;
                if (min == k) res++;
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
