package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                ret += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
