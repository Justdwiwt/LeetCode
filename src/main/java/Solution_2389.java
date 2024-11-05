package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        int[] ans = new int[m], pre = new int[n + 1];
        IntStream.range(0, n).forEach(i -> pre[i + 1] = pre[i] + nums[i]);
        IntStream.range(0, m).forEach(i -> ans[i] = queries[i] > pre[n] ? n : bisect(pre, queries[i] + 1));
        return ans;
    }

    int bisect(int[] pre, int target) {
        int left = 0, right = pre.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pre[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left - 1;
    }
}
