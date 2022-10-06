package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(adjacentPairs).forEach(adjacentPair -> {
            map.merge(adjacentPair[0], new ArrayList<>(), (a, b) -> a).add(adjacentPair[1]);
            map.merge(adjacentPair[1], new ArrayList<>(), (a, b) -> a).add(adjacentPair[0]);
        });
        int[] res = new int[m];
        map.keySet().stream().filter(integer -> map.get(integer).size() == 1).findFirst().ifPresent(integer -> res[0] = integer);
        res[1] = map.get(res[0]).get(0);
        IntStream.range(2, m).forEach(i -> {
            List<Integer> list = map.get(res[i - 1]);
            res[i] = res[i - 2] == list.get(0) ? list.get(1) : list.get(0);
        });
        return res;
    }
}
