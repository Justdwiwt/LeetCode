package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_2824 {
    public int countPairs(List<Integer> nums, int target) {
        return (int) IntStream.range(0, nums.size())
                .flatMap(i -> IntStream.range(i + 1, nums.size()).map(j -> nums.get(i) + nums.get(j)))
                .filter(sum -> sum < target)
                .count();
    }
}
