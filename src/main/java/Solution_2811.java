package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_2811 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        return n <= 2 || IntStream.range(1, n).anyMatch(i -> nums.get(i - 1) + nums.get(i) >= m);
    }
}
