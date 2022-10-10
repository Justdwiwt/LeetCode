package main.java;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution_1725 {
    public int countGoodRectangles(int[][] rectangles) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Arrays.stream(rectangles)
                .map((lens -> Math.min(lens[0], lens[1])))
                .forEach((len) -> tm.put(len, tm.getOrDefault(len, 0) + 1));
        return tm.lastEntry().getValue();
    }
}
