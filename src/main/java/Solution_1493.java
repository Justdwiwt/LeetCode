package main.java;

public class Solution_1493 {
    public int longestSubarray(int[] nums) {
        int res = 0, sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += (nums[right] & 1);
            while (left < right && sum <= right - left - 1) {
                if (nums[left] == 1) sum--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
