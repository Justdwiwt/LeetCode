package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        int[][] arr = IntStream.range(0, n).mapToObj(i -> new int[]{tasks[i][0], tasks[i][1], i}).toArray(int[][]::new);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        long curTime = arr[0][0];
        int idx = 0, resId = 0;
        while (idx < n && arr[idx][0] == curTime)
            pq.add(arr[idx++]);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res[resId++] = poll[2];
            curTime += poll[1];
            while (idx < n && arr[idx][0] <= curTime)
                pq.add(arr[idx++]);
            if (pq.isEmpty() && idx < n) {
                curTime = arr[idx][0];
                while (idx < n && arr[idx][0] == curTime)
                    pq.add(arr[idx++]);
            }
        }
        return res;
    }
}
