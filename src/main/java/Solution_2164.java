package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2164 {
    public int[] sortEvenOdd(int[] nums) {
        List<PriorityQueue<Integer>> pq = Arrays.asList(new PriorityQueue<>(), new PriorityQueue<>(Comparator.reverseOrder()));
        IntStream.range(0, nums.length).forEach(i -> pq.get(i % 2).offer(nums[i]));
        return IntStream.range(0, nums.length).map(i -> pq.get(i % 2).poll()).toArray();
    }
}
