package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        IntStream.range(0, len).forEach(i -> nums[i] += (d * (s.charAt(i) == 'R' ? 1 : -1)));
        int mod = (int) 1e9 + 7;
        long ans = 0;
        Arrays.sort(nums);
        int sum = 0;
        long preSum = 0;
        for (int i = 1; i < len; i++) {
            preSum = (preSum + ((long) nums[i] - nums[i - 1]) * i) % mod;
            ans += preSum;
            ans %= mod;
        }
        return (int) ans;
    }
}
