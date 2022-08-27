package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_1943 {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeSet<Integer> ts = new TreeSet<>();
        long[] sum = new long[100001];
        List<List<Long>> res = new ArrayList<>();
        Arrays.stream(segments).forEach(seg -> {
            ts.add(seg[0]);
            ts.add(seg[1]);
            sum[seg[0]] += seg[2];
            sum[seg[1]] -= seg[2];
        });
        IntStream.range(1, 100001).forEach(i -> sum[i] += sum[i - 1]);
        Integer pre = null;
        for (int cur : ts) {
            if (pre != null && sum[pre] > 0) {
                List<Long> seg = new ArrayList<>();
                seg.add((long) pre);
                seg.add((long) cur);
                seg.add(sum[pre]);
                res.add(seg);
            }
            pre = cur;
        }
        return res;
    }
}
