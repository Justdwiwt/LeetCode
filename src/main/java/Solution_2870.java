package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2870 {
    public int minOperations(int[] nums) {
        int cn = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return -1;
            cn += entry.getValue() / 3 + (entry.getValue() % 3 != 0 ? 1 : 0);
        }
        return cn;
    }
}
