package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution_2054 {
    public int maxTwoEvents(int[][] events) {
        int res = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        for (int[] event : events) {
            Integer maxVal = tm.lowerEntry(event[0]).getValue();
            res = Math.max(res, maxVal + event[2]);
            tm.put(event[1], Math.max(event[2], tm.floorEntry(event[1]).getValue()));
        }
        return res;
    }
}
