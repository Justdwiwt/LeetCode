package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1711 {
    public static int countPairs(int[] ds) {
        Map<Integer, Long> map = new HashMap<>();
        long res = 0;
        for (int d : ds) {
            for (int i = 0; i <= 21; i++)
                res = (res + map.getOrDefault((1 << i) - d, 0L)) % 1000000007;
            map.put(d, map.getOrDefault(d, 0L) + 1);
        }
        return (int) res;
    }
}
