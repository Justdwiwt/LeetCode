package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0], i = 0;
        Arrays.sort(times, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        while (true) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0])
                availableChairs.offer(pq.poll()[1]);
            if (times[i][0] == targetArrival) break;
            pq.offer(new int[]{times[i++][1], availableChairs.isEmpty() ? pq.size() : availableChairs.poll()});
        }
        return !availableChairs.isEmpty() ? availableChairs.poll() : pq.size();
    }
}
