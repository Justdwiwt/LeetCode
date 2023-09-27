package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_391 {
    public boolean isRectangleCover(int[][] rectangles) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Arrays.stream(rectangles).forEach(r -> {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            Map<Integer, Integer> m1 = map.computeIfAbsent(x1, k -> new HashMap<>());
            m1.put(y1, m1.getOrDefault(y1, 0) + 1);
            m1.put(y2, m1.getOrDefault(y2, 0) - 1);
            Map<Integer, Integer> m2 = map.computeIfAbsent(x2, k -> new HashMap<>());
            m2.put(y2, m2.getOrDefault(y2, 0) + 1);
            m2.put(y1, m2.getOrDefault(y1, 0) - 1);
        });
        int cnt = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> e1 : map.entrySet())
            for (Map.Entry<Integer, Integer> e2 : e1.getValue().entrySet()) {
                int v = e2.getValue();
                if (v != 0 && v != 1 && v != -1) return false;
                if (v == 1 || v == -1) cnt++;
            }
        return cnt == 4;
    }
}
