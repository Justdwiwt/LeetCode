package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2009 {
    public int minOperations(int[] nums) {
        int n = nums.length, maxNum = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (nums[i] - nums[j] >= n) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
            maxNum = Math.max(maxNum, map.size());
        }
        return n - maxNum;
    }
}
