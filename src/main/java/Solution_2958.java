package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.get(nums[i]) > k) {
                int out = nums[left];
                map.put(out, map.get(out) - 1);
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
