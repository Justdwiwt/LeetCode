package main.java;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_506 {
    public static String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = IntStream.range(0, score.length).boxed().collect(Collectors.toMap(i -> score[i], i -> i, (a, b) -> b));
        LinkedList<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        String[] res = new String[score.length];
        int rank = 1;
        while (!entryList.isEmpty()) {
            Map.Entry<Integer, Integer> entry = entryList.removeFirst();
            switch (rank) {
                case 1:
                    res[entry.getValue()] = "Gold Medal";
                    break;
                case 2:
                    res[entry.getValue()] = "Silver Medal";
                    break;
                case 3:
                    res[entry.getValue()] = "Bronze Medal";
                    break;
                default:
                    res[entry.getValue()] = String.valueOf(rank);
                    break;
            }
            rank++;
        }
        return res;
    }
}
