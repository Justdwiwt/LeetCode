package main.java;

import java.util.stream.IntStream;

public class Solution_1862 {
    final int M = 1000000007;

    public int sumOfFlooredPairs(int[] nums) {
        int[] cnt = new int[100001];
        IntStream.range(0, nums.length).forEach(i -> cnt[nums[i]]++);
        IntStream.rangeClosed(1, 100000).forEach(i -> cnt[i] += cnt[i - 1]);
        long res = 0;
        for (int i = 1; i <= 100000; i++)
            for (int j = 1; j <= 100000 / i; j++)
                res = (res + (long) (cnt[i] - cnt[i - 1]) * (long) j * (long) (cnt[Math.min(100000, (j + 1) * i - 1)] - cnt[j * i - 1])) % M;
        return (int) res;
    }
}
