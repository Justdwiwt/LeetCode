package main.java;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(hand).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        while (map.size() >= groupSize) {
            int start = map.ceilingKey(-1);
            map.put(start, map.get(start) - 1);
            if (map.get(start) == 0) map.remove(start);
            int n = groupSize - 1;
            while (n-- > 0) {
                if (map.get(start + 1) == null) return false;
                map.put(start + 1, map.get(start + 1) - 1);
                if (map.get(start + 1) == 0) map.remove(start + 1);
                start++;
            }
        }
        return map.size() == 0;
    }
}
