package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, pre = 0;
        map.put(0, 1);
        for (int num : nums) {
            if (num % 2 == 1) pre++;
            if (map.containsKey(pre - k)) res += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
