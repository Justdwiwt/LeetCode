package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long res = 0;
        int p = 0;
        for (int num : nums) {
            p ^= num;
            res += map.getOrDefault(p, 0);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        return res;
    }
}
