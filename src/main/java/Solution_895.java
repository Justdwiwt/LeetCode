package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_895 {
    static class FreqStack {

        private int idx;
        private final Map<Integer, Integer> map;
        private final PriorityQueue<int[]> queue;

        public FreqStack() {
            queue = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[2] - o1[2] : o2[1] - o1[1]);
            map = new HashMap<>();
            idx = 0;
        }

        public void push(int x) {
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
            queue.add(new int[]{x, cnt, idx++});
        }

        public int pop() {
            int[] poll = queue.poll();
            assert poll != null;
            map.put(poll[0], poll[1] - 1);
            return poll[0];
        }
    }
}
