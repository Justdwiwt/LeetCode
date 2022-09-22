package main.java;

import java.util.*;

public class Solution_1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        if (logs == null || logs.length == 0 || logs[0].length == 0) return res;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Arrays.stream(logs).forEach(array -> {
            if (!map.containsKey(array[0])) map.put(array[0], new HashSet<>());
            map.get(array[0]).add(array[1]);
        });
        map.keySet().forEach(key -> res[map.get(key).size() - 1]++);
        return res;
    }
}
