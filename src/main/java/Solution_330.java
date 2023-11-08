package main.java;

public class Solution_330 {
    public int minPatches(int[] nums, int n) {
        int res = 0, i = 0;
        long r = 0;
        while (r < n) {
            if (i < nums.length && nums[i] <= r + 1) r += nums[i++];
            else {
                r = r + r + 1;
                res++;
            }
        }
        return res;
    }
}
