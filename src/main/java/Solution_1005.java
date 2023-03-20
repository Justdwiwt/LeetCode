package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int K) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue)
                .toArray();
        int N = nums.length;
        for (int i = 0; i < N; i++)
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        if (K % 2 == 1) nums[N - 1] = -nums[N - 1];
        return Arrays.stream(nums).sum();
    }
}
