package main.java;

import java.util.Arrays;

public class Solution_2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = Arrays.stream(nums).max().orElse(0);
        while (left <= right) {
            int mid = (left + right) / 2;
            int pair = getPair(nums, mid);
            if (pair >= p) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private int getPair(int[] nums, int limit) {
        int pair = 0;
        Integer last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (last != null && num - last <= limit) {
                pair++;
                last = null;
            } else last = num;
        }
        return pair;
    }
}
