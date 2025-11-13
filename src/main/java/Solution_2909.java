package main.java;

public class Solution_2909 {
    public int minimumSum(int[] nums) {
        int l = 1000000000, r = 1000000000, n = nums.length;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            l = Math.min(l, nums[i]);
            r = Math.min(r, nums[n - i - 1]);
            left[i] = l;
            right[n - i - 1] = r;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++)
            if (left[i] < nums[i] && right[i] < nums[i])
                res = Math.min(res, left[i] + right[i] + nums[i]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
