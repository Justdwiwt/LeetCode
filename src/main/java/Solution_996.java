package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_996 {
    boolean[] used;
    int res = 0;

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        used = new boolean[n];
        dfs(nums, 0, -1);
        return res;
    }

    private void dfs(int[] nums, int k, int p) {
        if (k == nums.length) {
            res++;
            return;
        }
        IntStream.range(0, nums.length)
                .filter(i -> i <= 0 || used[i - 1] || nums[i] != nums[i - 1])
                .filter(i -> !used[i])
                .filter(i -> p == -1 || isSquare(nums[p] + nums[i]))
                .forEach(i -> {
                    used[i] = true;
                    dfs(nums, k + 1, i);
                    used[i] = false;
                });
    }

    private boolean isSquare(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }
}
