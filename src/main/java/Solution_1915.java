package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1915 {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        int mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(mask, 1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            for (int j = 0; j < 10; j++)
                res += map.getOrDefault(mask ^ (1 << j), 0);
            res += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return res;
    }
}
