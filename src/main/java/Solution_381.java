package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_381 {
    static class RandomizedCollection {
        HashMap<Integer, List<Integer>> map;
        int[] table;
        int top = 0;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            table = new int[10000];
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            table[top++] = val;
            if (map.containsKey(val)) {
                map.get(val).add(top - 1);
                return false;
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(top - 1);
                map.put(val, tmp);
                return true;
            }
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            else {
                List<Integer> removeList = map.get(val);
                int p = removeList.get(removeList.size() - 1);

                if (map.get(val).size() > 1) removeList.remove(removeList.size() - 1);
                else map.remove(val);
                if (p < top - 1) {
                    table[p] = table[top - 1];
                    List<Integer> lastList = map.get(table[top - 1]);
                    IntStream.range(0, lastList.size()).filter(i -> lastList.get(i) == top - 1).forEach(i -> lastList.set(i, p));
                }
                top--;
                return true;
            }
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int ran = (int) (Math.random() * top);
            return table[ran];
        }
    }
}
