package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1726 {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length, res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++) {
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        res = map.keySet().stream().mapToInt(key -> key).map(map::get).filter(val -> val >= 2).map(val -> (val * (val - 1)) / 2).sum();
        return res * 8;
    }
}
