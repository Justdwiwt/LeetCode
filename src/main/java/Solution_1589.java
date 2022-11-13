package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] counts = new int[nums.length];
        Arrays.stream(requests).forEach(r -> {
            counts[r[0]]++;
            if (r[1] != (nums.length - 1)) counts[r[1] + 1]--;
        });
        IntStream.range(1, counts.length).forEach(i -> counts[i] = counts[i - 1] + counts[i]);
        Arrays.sort(counts);
        Arrays.sort(nums);
        long res = IntStream.range(0, nums.length).mapToLong(i -> (long) nums[i] * counts[i]).sum();
        return (int) (res % 1000000007);
    }
}
