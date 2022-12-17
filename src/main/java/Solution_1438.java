package main.java;

import java.util.TreeMap;

public class Solution_1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            tm.compute(nums[right++], (k, v) -> v == null ? 1 : v + 1);
            if (tm.lastKey() - tm.firstKey() > limit)
                tm.compute(nums[left++], (k, v) -> v == 1 ? null : v - 1);
        }
        return right - left;
    }
}
