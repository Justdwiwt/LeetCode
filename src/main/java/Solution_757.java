package main.java;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution_757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        TreeSet<Integer> items = new TreeSet<>();
        items.add(intervals[0][1] - 1);
        items.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] item = intervals[i];
            Integer a = items.ceiling(item[0]);
            Integer b = items.floor(item[1]);
            if (a != null && !a.equals(b)) continue;
            int size = items.size() + (a == null ? 2 : 1);
            int val = item[1];
            while (items.size() < size) items.add(val--);
        }
        return items.size();
    }
}
