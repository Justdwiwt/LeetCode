package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        IntStream.range(0, servers.length).mapToObj(i -> new int[]{servers[i], i, 0}).forEach(free::add);
        int time = 0;
        int[] res = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            if (time < i) time = i;
            while ((!busy.isEmpty() && busy.peek()[2] <= time) || free.isEmpty()) {
                int[] ints = busy.poll();
                free.add(ints);
                time = ints[2];
            }
            int[] server = free.poll();
            res[i] = server[1];
            int end = tasks[i] + time;
            busy.add(new int[]{server[0], server[1], end});
        }
        return res;
    }
}
