package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        IntStream.range(0, nums.length).forEach(i -> nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]));
        return IntStream.range(0, nums.length).filter(i -> nums[i] > 0).mapToObj(i -> i + 1).collect(Collectors.toList());
    }
}
