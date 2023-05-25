package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_805 {
    public boolean splitArraySameAverage(int[] nums) {
        int sum, n = nums.length;
        sum = Arrays.stream(nums, 0, n).sum();
        IntStream.range(0, n).forEach(i -> nums[i] = nums[i] * n - sum);
        int n1 = n >> 1, n2 = n - n1, max1 = 1 << n1, max2 = 1 << n2;
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, max1).map(i -> findSum(i, nums, 0)).forEach(a -> map.put(a, map.getOrDefault(a, 0) + 1));
        if (IntStream.range(1, max2 - 1).map(i -> findSum(i, nums, n1)).anyMatch(a -> a == 0 || map.containsKey(-a)))
            return true;
        int a1 = findSum(max1 - 1, nums, 0), a2 = findSum(max2 - 1, nums, n1);
        return a1 + a2 != 0 && map.containsKey(-a2) || a1 + a2 == 0 && map.get(-a2) > 1;
    }

    private int findSum(int mask, int[] nums, int start) {
        int res = 0;
        for (int i = 0; mask > 0; i++, mask >>= 1)
            if ((mask & 1) == 1) res += nums[start + i];
        return res;
    }
}
