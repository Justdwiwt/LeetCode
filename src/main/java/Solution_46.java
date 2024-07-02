package main.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_46 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        backTracking(nums);
        return result;
    }

    private void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        IntStream.range(0, nums.length).filter(i -> !path.contains(nums[i])).forEach(i -> {
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
        });
    }
}
