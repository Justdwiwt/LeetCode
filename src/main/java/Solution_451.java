package main.java;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_451 {
    public String frequencySort(String s) {
        int[] cnt = new int[128];
        char[] cs = s.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> cnt[b] - cnt[a]);
        for (char c : cs) cnt[c]++;
        IntStream.range(0, 128).filter(i -> cnt[i] > 0).forEach(pq::add);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int c = pq.poll();
            for (int i = 0; i < cnt[c]; i++) sb.append((char) c);
        }
        return sb.toString();
    }
}
