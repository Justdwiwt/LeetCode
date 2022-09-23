package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, mod = 1000000007;
        for (int num : nums) {
            int reversed = Integer.parseInt(new StringBuilder(num + "").reverse().toString());
            int gap = num - reversed;
            res = (res + map.getOrDefault(gap, 0)) % mod;
            map.put(gap, map.getOrDefault(gap, 0) + 1);
        }
        return res;
    }
}
