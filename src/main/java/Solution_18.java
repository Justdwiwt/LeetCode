package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int tar) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) return ans;
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == (long) tar) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        while (l < r && nums[l] == nums[l - 1])
                            ++l;
                        while (l < r && nums[r] == nums[r + 1])
                            --r;
                    } else if (sum < (long) tar) ++l;
                    else --r;
                }
            }
        }
        return ans;
    }
}
