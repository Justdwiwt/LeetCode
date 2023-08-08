package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        res.addAll(set);
        return res;
    }

    void dfs(int[] nums, int index) {
        if (list.size() >= 2) set.add(new ArrayList<Integer>(list));
        IntStream.range(index, nums.length).filter(i -> list.size() == 0 || nums[i] >= list.get(list.size() - 1)).forEach(i -> {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        });
    }
}
