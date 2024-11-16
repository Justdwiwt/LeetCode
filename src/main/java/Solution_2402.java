package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2402 {
    private static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));
        int[] count = new int[n];
        TreeSet<Integer> meetingRoom = IntStream.range(0, n).boxed().collect(Collectors.toCollection(TreeSet::new));
        PriorityQueue<Pair<Long, Integer>> heap = new PriorityQueue<>((x, y) -> (long) x.first == y.first ? x.second - y.second : Long.compare(x.first, y.first));
        Arrays.stream(meetings).forEach(meeting -> {
            while (!heap.isEmpty() && meeting[0] >= heap.peek().first)
                meetingRoom.add(heap.poll().second);
            if (meetingRoom.isEmpty()) {
                Pair<Long, Integer> cur = heap.poll();
                if (cur != null) count[cur.second]++;
                if (cur != null) heap.offer(new Pair<>(cur.first + (long) meeting[1] - meeting[0], cur.second));
            } else {
                int get = meetingRoom.first();
                heap.offer(new Pair<>((long) meeting[1], get));
                count[get]++;
                meetingRoom.remove(get);
            }
        });
        int max = 0;
        for (int i = 1; i < n; i++)
            if (count[max] < count[i]) max = i;
        return max;
    }
}
