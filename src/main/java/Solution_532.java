package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(5000);
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) res += (map.containsKey(num - k) ? 1 : 0) + (map.containsKey(num + k) ? 1 : 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (k == 0 && map.get(num) == 2) res++;
        }
        return res;
    }
}
