package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];
        int max = 0;
        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> ts;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        ts = IntStream.range(0, k).boxed().collect(Collectors.toCollection(TreeSet::new));
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= arrival[i]) ts.add(pq.poll()[0]);
            if (ts.size() == 0) continue;
            Integer ne = ts.ceiling(i % k);
            if (ne == null) ne = ts.ceiling(0);
            if (ne == null) continue;
            ts.remove(ne);
            pq.add(new int[]{ne, arrival[i] + load[i]});
            max = Math.max(++cnt[ne], max);
        }
        for (int i = 0; i < k; i++)
            if (cnt[i] == max) res.add(i);
        return res;
    }
}
