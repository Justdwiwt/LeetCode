package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[] isForbidden = new boolean[6001];
        Arrays.stream(forbidden).forEach(i -> isForbidden[i] = true);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{0, 0});
        boolean[] visited = new boolean[6001];
        while (!pq.isEmpty()) {
            int[] o = pq.poll();
            int curr = o[0], step = o[1];
            if (curr == x) return step;
            if (visited[curr]) continue;
            visited[curr] = true;
            int next = curr + a;
            if (next > 6000 || isForbidden[next]) continue;
            pq.offer(new int[]{next, step + 1});
            next -= b;
            if (next < 0 || isForbidden[next]) continue;
            pq.offer(new int[]{next, step + 2});
        }
        return -1;
    }
}
