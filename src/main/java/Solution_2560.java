package main.java;

import java.util.Arrays;

public class Solution_2560 {
    public int minCapability(int[] nums, int k) {
        int l = Arrays.stream(nums).min().orElse(0);
        int r = Arrays.stream(nums).max().orElse(0) + 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] <= mid) {
                    i++;
                    cnt++;
                }
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
