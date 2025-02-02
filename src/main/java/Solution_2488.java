package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2488 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length, f = 0, sum = 0, m = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                f = i;
                break;
            }
            sum += (nums[i] < k ? -1 : 1);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        for (int i = f; i < n; i++) {
            sum += (nums[i] < k ? -1 : 1);
            m += map.getOrDefault(sum - 1, 0);
            m += map.getOrDefault(sum - 2, 0);
        }
        return m;
    }
}
