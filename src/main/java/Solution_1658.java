package main.java;

import java.util.Arrays;

public class Solution_1658 {
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            cur += nums[right++];
            while (cur > sum - x && left < nums.length) cur -= nums[left++];
            if (cur == sum - x) maxPart = Math.max(maxPart, right - left);
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }
}
