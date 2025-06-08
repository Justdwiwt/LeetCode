package main.java;

import java.util.stream.IntStream;

public class Solution_2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length, count[] = new int[55], ans[] = new int[n - k + 1];
        IntStream.range(0, k - 1).filter(i -> nums[i] < 0).forEach(i -> count[-nums[i]]++);
        for (int i = k - 1; i < n; i++) {
            if (i >= k && nums[i - k] < 0) count[-nums[i - k]]--;
            if (nums[i] < 0) count[-nums[i]]++;
            int num = 0;
            for (int j = 50; j > 0; j--) {
                num += count[j];
                if (num >= x) {
                    ans[i - k + 1] = -j;
                    break;
                }
            }
        }
        return ans;
    }
}
