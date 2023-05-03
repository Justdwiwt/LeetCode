package main.java;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0, n = stations.length;
        for (int i = 0; startFuel < target; res++) {
            while (i < n && stations[i][0] <= startFuel) pq.offer(stations[i++][1]);
            if (pq.isEmpty()) return -1;
            startFuel += pq.poll();
        }
        return res;
    }
}
