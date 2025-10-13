package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        return IntStream.range(0, n).filter(i -> Integer.bitCount(i) == k).map(nums::get).sum();
    }
}
