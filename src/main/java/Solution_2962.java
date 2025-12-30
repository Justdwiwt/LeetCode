package main.java;

import java.util.Arrays;

public class Solution_2962 {
    public long countSubarrays(int[] nums, int k) {
        int cnt = 0;
        int maxNum = Arrays.stream(nums).max().orElse(0);

        long ans = 0, pre = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxNum) cnt++;
            int cur = 0;
            while (cnt >= k && l <= i) {
                if (nums[l] == maxNum) cnt--;
                l++;
                cur++;
            }
            ans += cur + pre;
            pre = cur + pre;
        }
        return ans;
    }
}
