package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution_2233 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        while (k-- > 0) pq.add(pq.poll() + 1);
        long res = 1;
        while (pq.size() > 0) res = (res * pq.poll()) % 1000000007;
        return (int) res;
    }
}
