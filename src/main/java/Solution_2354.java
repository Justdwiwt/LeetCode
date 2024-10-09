package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2354 {
    public long countExcellentPairs(int[] nums, int k) {
        int[] bitCnt = new int[33];
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).filter(set::add).forEach(num -> ++bitCnt[Integer.bitCount(num)]);
        long res = 0;
        for (int i = 0; i <= 32; i++)
            for (int j = Math.max(0, k - i); j <= 32; j++)
                res += (long) bitCnt[i] * bitCnt[j];
        return res;
    }
}
