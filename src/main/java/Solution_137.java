package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_137 {
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        Arrays.stream(nums).forEach(num -> IntStream.range(0, 32).forEach(j -> cnt[j] += (num >> j) & 1));
        return IntStream.range(0, 32).map(i -> (cnt[i] % 3) << i).sum();
    }
}
