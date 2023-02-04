package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution_1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] times = IntStream.range(0, len).mapToObj(i -> new int[]{startTime[i], endTime[i], profit[i]}).toArray(int[][]::new);
        Arrays.sort(times, (o1, o2) -> o1[1] == o2[1] ? o2[2] - o1[2] : o1[1] - o2[1]);
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(times[0][1], times[0][2]);
        int pre, cur;
        Map.Entry<Integer, Integer> entry;
        for (int i = 1; i < len; i++) {
            entry = tm.floorEntry(times[i][0]);
            pre = entry == null ? 0 : entry.getValue();
            cur = tm.lastEntry().getValue();
            if (times[i][2] + pre > cur) tm.put(times[i][1], times[i][2] + pre);
        }
        return tm.lastEntry().getValue();
    }
}
