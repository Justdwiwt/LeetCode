package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_90 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        IntStream.range(startIndex, nums.length).filter(i -> i <= startIndex || nums[i] != nums[i - 1]).forEach(i -> {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        });
    }
}
