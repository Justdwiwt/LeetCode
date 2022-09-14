package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution_1854 {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new TreeMap<>();

        Arrays.stream(logs).forEach(log -> {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            map.put(log[1], map.getOrDefault(log[1], 0) - 1);
        });

        int year = 0;
        int number = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            if (sum > number) {
                number = sum;
                year = entry.getKey();
            }
        }

        return year;
    }
}
