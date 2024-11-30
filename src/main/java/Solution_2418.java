package main.java;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
        IntStream.range(0, names.length).forEach(i -> map.put(heights[i], names[i]));
        return map.values().toArray(new String[names.length]);
    }
}
