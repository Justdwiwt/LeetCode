package main.java;

import java.util.HashMap;

public class Solution_2013 {
    static class DetectSquares {
        HashMap<Integer, HashMap<Integer, Integer>> points;

        public DetectSquares() {
            points = new HashMap<>();
        }

        public void add(int[] point) {
            points.putIfAbsent(point[0], new HashMap<>());

            HashMap<Integer, Integer> yCounts = points.get(point[0]);
            yCounts.put(point[1], 1 + yCounts.getOrDefault(point[1], 0));
        }

        public int count(int[] point) {
            if (!points.containsKey(point[0])) return 0;

            int cnt = 0;

            HashMap<Integer, Integer> yCounts = points.get(point[0]);
            for (int y : yCounts.keySet()) {
                if (y == point[1]) continue;

                int yCount = yCounts.get(y);
                int diff = Math.abs(y - point[1]);

                cnt += countSquares(point[1], y, point[0] - diff) * yCount;
                cnt += countSquares(point[1], y, point[0] + diff) * yCount;
            }

            return cnt;
        }

        private int countSquares(int y1, int y2, int x) {
            if (!points.containsKey(x)) return 0;

            int count1 = points.get(x).getOrDefault(y1, 0);
            int count2 = points.get(x).getOrDefault(y2, 0);

            return count1 * count2;
        }
    }
}
