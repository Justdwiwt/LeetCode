package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_447 {
    public int dist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) continue;
                int d = dist(points[i], points[j]);
                res += map.getOrDefault(d, 0) * 2;
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }
        return res;
    }
}
