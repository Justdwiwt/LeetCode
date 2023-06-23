package main.java;

import java.util.Arrays;

public class Solution_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int size = sum / k;
        int[] buc = new int[k];
        Arrays.fill(buc, size);
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, buc);
    }

    private boolean dfs(int[] nums, int index, int[] buc) {
        if (index < 0) return true;
        for (int i = 0; i < buc.length; i++) {
            if (buc[i] < nums[index] || (i > 0 && buc[i] == buc[i - 1])) continue;
            buc[i] -= nums[index];
            if (dfs(nums, index - 1, buc)) return true;
            buc[i] += nums[index];
        }
        return false;
    }
}
