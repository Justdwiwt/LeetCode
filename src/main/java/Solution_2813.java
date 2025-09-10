package main.java;

import java.util.*;

public class Solution_2813 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (o1, o2) -> o2[0] - o1[0]);
        Set<Integer> set = new HashSet<>();
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < k; i++) {
            res += items[i][0];
            if (!set.contains(items[i][1])) set.add(items[i][1]);
            else pq.add(items[i][0]);
        }
        long max = res + (long) set.size() * set.size();
        for (int i = k; i < items.length; i++) {
            if (set.size() == k) break;
            if (set.contains(items[i][1])) continue;
            set.add(items[i][1]);
            res = res - pq.poll() + items[i][0];
            max = Math.max(max, res + (long) set.size() * set.size());
        }
        return max;
    }
}
