package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2537 {
    public long countGood(int[] nums, int k) {
        int len = nums.length;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, cnt = 0;
        while (r < len) {
            cnt += map.getOrDefault(nums[r], 0);
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
            while (cnt >= k) {
                res += len - r + 1;
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                cnt -= map.get(nums[l]);
                l++;
            }
        }
        return res;
    }
}
