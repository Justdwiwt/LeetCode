package main.java;

import java.util.TreeMap;

public class Solution_528 {
    static class Solution {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();
        private final int limit;

        public Solution(int[] w) {
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                map.put(sum, i);
                sum += w[i];
            }
            limit = sum;
        }

        public int pickIndex() {
            int num = (int) (Math.random() * limit);
            return map.get(map.floorKey(num));
        }
    }
}
