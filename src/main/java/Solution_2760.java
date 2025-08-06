package main.java;

public class Solution_2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int N = nums.length;
        int ans = 0;
        int i = 0;
        while (i < N) {
            boolean flag = false;
            int r = i;
            while (r < N && nums[r] <= threshold && flag ^ (nums[r] & 1) == 0) {
                flag ^= true;
                r++;
            }
            ans = Math.max(ans, r - i);
            i = r == i ? ++i : r;
        }
        return ans;
    }
}
