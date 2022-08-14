package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        Arrays.stream(rectangles).forEach(rec -> map.put((double) rec[0] / rec[1], map.getOrDefault((double) rec[0] / rec[1], 0L) + 1));
        return map
                .values()
                .stream()
                .mapToLong(aLong -> aLong * (aLong - 1) / 2)
                .sum();
    }
}
