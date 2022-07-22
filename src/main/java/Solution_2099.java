package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, Comparator.comparingInt(pair -> pair[0]));
        IntStream.range(0, nums.length).forEach(i -> {
            pq.add(new int[]{nums[i], i});
            if (pq.size() == k + 1) pq.poll();
        });
        ArrayList<int[]> pairs = new ArrayList<>(pq);
        pairs.sort(Comparator.comparingInt(pair -> pair[1]));

        return IntStream.range(0, k)
                .map(i -> pairs.get(i)[0])
                .toArray();
    }
}
