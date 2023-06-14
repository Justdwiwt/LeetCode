package main.java;

import java.util.TreeMap;

public class Solution_732 {
    static class MyCalendarThree {

        private final TreeMap<Integer, Integer> calendar;

        public MyCalendarThree() {
            calendar = new TreeMap<>();
        }

        public int book(int start, int end) {

            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);

            int max = 0;
            int active = 0;

            for (Integer d : calendar.values()) {
                active += d;
                if (active > max) {
                    max = active;
                }
            }

            return max;
        }

    }
}
