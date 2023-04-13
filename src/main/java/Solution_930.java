package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_930 {
    public int numSubarraysWithSum(int[] nums, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - S)) res += map.get(sum - S);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
