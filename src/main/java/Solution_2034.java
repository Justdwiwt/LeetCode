package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Solution_2034 {
    static class StockPrice {
        TreeMap<Integer, Integer> map;
        TreeMap<Integer, Set<Integer>> prices;

        public StockPrice() {
            map = new TreeMap<>();
            prices = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            Integer last = map.get(timestamp);
            if (last != null) {
                Set<Integer> set = prices.get(last);
                if (set.size() == 1) prices.remove(last);
                else set.remove(timestamp);
            }
            prices.computeIfAbsent(price, v -> new HashSet<>()).add(timestamp);
            map.put(timestamp, price);
        }

        public int current() {
            return map.lastEntry().getValue();
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }
}
