package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(intervals.length);
        priorityQueue.add(intervals[0][1]);
        IntStream.range(1, intervals.length).forEach(i -> {
            if (priorityQueue.peek() < intervals[i][0]) priorityQueue.poll();
            priorityQueue.add(intervals[i][1]);
        });
        return priorityQueue.size();
    }
}
