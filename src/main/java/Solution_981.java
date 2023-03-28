package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution_981 {
    static class TimeMap {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
