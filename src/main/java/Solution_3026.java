package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_3026 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>();
        long pre = 0, ans = -(long) 1e18;
        for (int a : nums) {
            pre += a;
            if (map.containsKey(a + k)) ans = Math.max(ans, pre - map.get(a + k) + a + k);
            if (map.containsKey(a - k)) ans = Math.max(ans, pre - map.get(a - k) + a - k);
            map.put(a, Math.min(map.getOrDefault(a, (long) 1e18), pre));
        }
        return ans == -1e18 ? 0 : ans;
    }
}
