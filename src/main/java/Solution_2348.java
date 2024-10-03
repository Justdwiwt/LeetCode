package main.java;

public class Solution_2348 {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int l = 0, r = 0, n = nums.length;
        while (r < n && nums[r] != 0) {
            l++;
            r++;
        }
        while (r < n) {
            res += r - l + 1;
            r++;
            if (r < n && nums[r] != 0) {
                while (r < n && nums[r] != 0) r++;
                l = r;
            }
        }
        return res;
    }
}
