package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int a : answers)
            if (map.containsKey(a) && map.get(a) > 0) map.put(a, map.get(a) - 1);
            else {
                num += a + 1;
                map.put(a, a);
            }
        return num;
    }
}
