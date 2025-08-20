package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2780 {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        nums.forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        int x = -1, y = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > y) {
                x = key;
                y = val;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == x) cnt++;
            if (2 * cnt > i + 1 && 2 * (y - cnt) > n - 1 - i) return i;
        }

        return -1;
    }
}
