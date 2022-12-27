package main.java;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1396 {
    static class UndergroundSystem {

        Map<Integer, Pair<String, Integer>> checkInMap;
        Map<Integer, Pair<String, Integer>> checkOutMap;
        Map<String, List<Integer>> stationMap;

        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            checkOutMap = new HashMap<>();
            stationMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            checkOutMap.put(id, new Pair<>(stationName, t));

            String startStation = checkInMap.get(id).getKey();
            String endStation = checkOutMap.get(id).getKey();
            int period = checkOutMap.get(id).getValue() - checkInMap.get(id).getValue();
            String station = startStation + "-" + endStation;

            if (!stationMap.containsKey(station)) {
                stationMap.put(station, new ArrayList<>());
            }

            stationMap.get(station).add(period);
        }

        public double getAverageTime(String startStation, String endStation) {
            String station = startStation + "-" + endStation;

            if (stationMap.get(station) != null) {
                int sum = stationMap.get(station).stream().mapToInt(time -> time).sum();
                return sum * 1.0 / stationMap.get(station).size();
            }

            return 0.0;
        }
    }

}
