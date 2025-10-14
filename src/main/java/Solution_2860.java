package main.java;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2860 {
    public int countWays(List<Integer> nums) {
        nums.sort(Comparator.comparingInt(o -> o));
        int m = nums.get(0) > 0 ? 1 : 0, len = nums.size();
        m += (int) IntStream.range(0, len).filter(i -> i + 1 > nums.get(i) && (i + 1 >= len || i + 1 < nums.get(i + 1))).count();
        return m;
    }
}
