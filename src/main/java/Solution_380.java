package main.java;

import java.util.*;

public class Solution_380 {
    static class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(idx, last);
            list.remove(list.size() - 1);
            map.put(last, idx);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
