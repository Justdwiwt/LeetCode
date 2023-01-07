package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        int day = 1;
        int res = 0;
        while (i < events.length || !queue.isEmpty()) {
            while (i < events.length && events[i][0] == day) {
                queue.add(events[i][1]);
                i++;
            }
            while (!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.poll();
                res++;
            }
            day++;
        }
        return res;
    }
}
