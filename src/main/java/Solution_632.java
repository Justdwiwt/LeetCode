package main.java;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int min = 100000, max = -100000;
        int k = 0, val;
        for (int i = 0; i < nums.size(); ++i) {
            val = nums.get(i).get(k);
            min = Math.min(min, val);
            max = Math.max(max, val);
            pq.add(new Integer[]{val, k, i});
        }
        int l = min, r = max;
        while (!pq.isEmpty()) {
            Integer[] top = pq.poll();
            k = top[1] + 1;
            if (k < nums.get(top[2]).size()) {
                top[0] = nums.get(top[2]).get(k);
                top[1] = k;
                assert pq.peek() != null;
                min = Math.min(top[0], pq.peek()[0]);
                max = Math.max(max, top[0]);
                pq.add(top);
                if (r - l > max - min) {
                    l = min;
                    r = max;
                }
            } else break;
        }
        return new int[]{l, r};
    }
}
