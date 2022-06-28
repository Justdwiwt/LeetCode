package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution_2208 {
    public int halveArray(int[] nums) {
        Queue<Double> pq = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(Double::valueOf)
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Collections.reverseOrder())));

        long total = Arrays.stream(nums).asLongStream().sum();
        double half = total / 2.0;
        double sum = 0;

        int res = 0;

        while (total - sum > half) {
            double n = pq.poll() / 2;
            sum += n;
            pq.offer(n);
            res++;
        }

        return res;
    }
}
