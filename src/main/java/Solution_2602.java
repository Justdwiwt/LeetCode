package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] s = new long[n + 1];
        IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + nums[i]);
        List<Long> ans = new ArrayList<>();
        Arrays.stream(queries).forEach(x -> {
            int idx = find(nums, x);
            long left = (long) x * idx - s[idx];
            long right = s[n] - s[idx] - (long) x * (n - idx);
            ans.add(left + right);
        });
        return ans;
    }

    private int find(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return right;
    }
}
