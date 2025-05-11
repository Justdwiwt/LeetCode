package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2597 {
    public int beautifulSubsets(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++)
                if (nums[j] != nums[i] - k)
                    list.add(nums[j]);
            int[] arr = list.stream().mapToInt(integer -> integer).toArray();
            int i1 = beautifulSubsets(arr, k);
            dp[i] += i1;
        }
        return dp[n - 1];
    }
}
