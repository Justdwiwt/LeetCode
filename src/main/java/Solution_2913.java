package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2913 {
    public int sumCounts(List<Integer> nums) {
        final int M = (int) 1e9 + 7;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);
                res = res + map.size() * map.size();
                res %= M;
            }
            map.clear();
        }
        return res;
    }
}
