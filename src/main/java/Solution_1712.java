package main.java;

import java.util.stream.IntStream;

public class Solution_1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length, res = 0;
        IntStream.range(1, n).forEach(i -> nums[i] += nums[i - 1]);
        for (int i = 0; i < n; ++i) {
            int low = i + 1, high = n - 2;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (nums[i] <= nums[mid] - nums[i]) high = mid - 1;
                else low = mid + 1;
            }
            int low2 = low, high2 = n - 2;
            while (low2 <= high2) {
                int mid2 = (low2 + high2) >>> 1;
                if (nums[mid2] - nums[i] <= nums[n - 1] - nums[mid2]) low2 = mid2 + 1;
                else high2 = mid2 - 1;
            }
            res += Math.max(high2 - low + 1, 0);
            res %= 1000000007;
        }
        return res;
    }
}
