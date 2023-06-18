package main.java;

import java.util.Arrays;

public class Solution_719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1000000;
        int n = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            int l = 0;
            for (int i = 1; i < n; i++) {
                while (l < n && nums[i] - nums[l] > mid) l++;
                cnt += i - l;
            }
            if (cnt >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
