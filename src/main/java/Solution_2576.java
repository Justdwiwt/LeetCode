package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = n / 2 + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (!check(mid, nums)) r = mid;
            else l = mid + 1;
        }
        return (r - 1) * 2;
    }

    public boolean check(int cnt, int[] nums) {
        int n = nums.length;
        return IntStream.range(0, cnt).noneMatch(i -> nums[i] * 2 > nums[n - cnt + i]);
    }
}
