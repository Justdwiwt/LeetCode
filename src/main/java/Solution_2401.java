package main.java;

import java.util.stream.IntStream;

public class Solution_2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int right = 1, left = 0;
        while (right < n && left < n)
            if (isNiceSubarray(nums, left, right)) {
                maxLen = Math.max(right - left + 1, maxLen);
                right++;
            } else left++;
        return maxLen;
    }

    private boolean isNiceSubarray(int[] nums, int left, int right) {
        return IntStream
                .rangeClosed(left, right)
                .noneMatch(i -> IntStream
                        .rangeClosed(i + 1, right)
                        .anyMatch(j -> (nums[i] & nums[j]) != 0));
    }
}
