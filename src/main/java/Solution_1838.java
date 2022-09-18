package main.java;

import java.util.Arrays;

public class Solution_1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, tmp = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (nums[j] * (j - i) - tmp > k) tmp -= nums[i++];
            tmp += nums[j];
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
