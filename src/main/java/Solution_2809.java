package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2809 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int size = nums1.size();
        int[][] nums = IntStream.range(0, size).mapToObj(i -> new int[]{nums2.get(i), nums1.get(i)}).toArray(int[][]::new);
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int[][] dp = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++)
            for (int j = i; j <= size; j++)
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + nums[j - 1][1] + nums[j - 1][0] * i);
        int n = nums1.stream().reduce(Integer::sum).orElse(0), m = nums2.stream().reduce(Integer::sum).orElse(0);
        return IntStream.rangeClosed(0, size).filter(i -> n + m * i - dp[i][size] <= x).findFirst().orElse(-1);
    }
}
