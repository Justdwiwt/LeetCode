package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_2897 {
    int mod = (int) 1e9 + 7;

    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[31];
        long ans = 0;
        nums.forEach(a -> IntStream.range(0, 31).forEach(j -> count[j] += a >> j & 1));
        for (int i = 0; i < k; i++) {
            long p = 0;
            for (int j = 0; j < 31; j++)
                if (count[j] != 0) {
                    p |= 1 << j;
                    count[j]--;
                }
            ans = (ans + p * p) % mod;
        }
        return (int) ans;
    }
}
