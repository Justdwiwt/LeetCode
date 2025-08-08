package main.java;

import java.util.TreeMap;

public class Solution_2762 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int l = 0, r = 0; r < n; ++r) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (l < r && map.lastKey() - map.firstKey() > 2) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                ++l;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
