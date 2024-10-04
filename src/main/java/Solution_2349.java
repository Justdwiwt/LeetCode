package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_2349 {
    static class NumberContainers {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Map<Integer, Integer> rMap = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            map.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
            rMap.put(index, number);
        }

        public int find(int number) {
            int re = -1;
            PriorityQueue<Integer> q = map.get(number);

            if (q == null) return re;

            while (!q.isEmpty()) {
                if (rMap.get(q.peek()) == number) {
                    re = q.peek();
                    break;
                } else q.poll();
            }

            return re;
        }
    }
}
