package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_47 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> line = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(line);
        } else IntStream.range(cur, nums.length).filter(i -> canSwap(nums, cur, i)).forEach(i -> {
            swap(nums, cur, i);
            dfs(nums, cur + 1);
            swap(nums, cur, i);
        });
    }

    private boolean canSwap(int[] nums, int begin, int end) {
        return IntStream.range(begin, end).noneMatch(i -> nums[i] == nums[end]);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
