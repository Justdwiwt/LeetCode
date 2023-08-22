package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        IntStream.range(0, nums.length).forEach(i -> {
            if (nums[Math.abs(nums[i]) - 1] < 0) res.add(Math.abs(nums[i]));
            else nums[Math.abs(nums[i]) - 1] *= -1;
        });
        return res;
    }
}
