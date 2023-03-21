package main.java;

public class Solution_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] == 0) k--;
            right++;
            while (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
