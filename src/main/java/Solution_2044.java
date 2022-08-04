package main.java;

import java.util.Arrays;

public class Solution_2044 {
    public int countMaxOrSubsets(int[] nums) {
        int or = Arrays.stream(nums).reduce(0, (a, b) -> a | b);
        return dfs(nums, or, 0, 0);
    }

    private int dfs(int[] nums, int or, int currOr, int pos) {
        if (pos == nums.length) return or == currOr ? 1 : 0;
        return dfs(nums, or, currOr, pos + 1) + dfs(nums, or, currOr | nums[pos], pos + 1);
    }
}
