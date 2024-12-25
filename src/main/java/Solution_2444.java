package main.java;

public class Solution_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, maxIndex = -1, minIndex = -1, outer = -1;
        long ans = 0L;
        for (int r = 0; r < n; ++r) {
            if (nums[r] == minK)
                minIndex = r;
            if (nums[r] == maxK)
                maxIndex = r;
            if (nums[r] > maxK || nums[r] < minK)
                outer = r;
            else
                ans += Math.max(Math.min(minIndex, maxIndex) - outer, 0);
        }
        return ans;
    }
}
