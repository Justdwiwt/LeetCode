package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2731 {
    static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = IntStream.range(0, n).mapToLong(i -> s.charAt(i) == 'L' ? (long) nums[i] - d : (long) nums[i] + d).toArray();
        Arrays.sort(pos);
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            res %= MOD;
        }
        return (int) res;
    }
}
