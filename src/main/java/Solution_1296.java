package main.java;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution_1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < first + k; i++) {
                if (!map.containsKey(i)) return false;
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) map.remove(i);
            }
        }
        return true;
    }
}
