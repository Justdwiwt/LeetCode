package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(k - num)) {
                res++;
                map.put(k - num, map.get(k - num) - 1);
                if (map.get(k - num) == 0) map.remove(k - num);
            } else map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
