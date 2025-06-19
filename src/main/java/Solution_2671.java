package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2671 {
    static class FrequencyTracker {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        public FrequencyTracker() {
        }

        public void add(int number) {
            if (map1.containsKey(number)) {
                int x = map1.get(number);
                add1(map1, number);
                add1(map2, x + 1);
                delete1(map2, x);
            } else {
                add1(map1, number);
                add1(map2, 1);
            }
        }

        public void deleteOne(int number) {
            if (map1.containsKey(number)) {
                int x = map1.get(number);
                delete1(map1, number);
                delete1(map2, x);
                if (x != 1) add1(map2, x - 1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return map2.containsKey(frequency);
        }

        public void add1(Map<Integer, Integer> map, int key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        public void delete1(Map<Integer, Integer> map, int key) {
            if (map.containsKey(key)) {
                int x = map.get(key);
                if (x == 1) map.remove(key);
                else map.put(key, x - 1);
            }
        }
    }
}
