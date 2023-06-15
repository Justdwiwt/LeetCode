package main.java;

import java.util.TreeSet;

public class Solution_729 {
    static class MyCalendar {
        TreeSet<int[]> calendars;

        public MyCalendar() {
            calendars = new TreeSet<>((a, b) -> {
                if (a[1] <= b[0]) return -1;
                else if (a[0] >= b[1]) return 1;
                else return 0;
            });
        }

        public boolean book(int start, int end) {
            int[] e = new int[]{start, end};
            return calendars.add(e);
        }
    }
}
