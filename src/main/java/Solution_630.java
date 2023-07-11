package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int times = 0;
        for (int[] cours : courses) {
            if (times + cours[0] <= cours[1]) {
                times += cours[0];
                queue.add(cours[0]);
            } else {
                queue.add(cours[0]);
                times = times + cours[0] - queue.poll();
            }
        }
        return queue.size();
    }
}
