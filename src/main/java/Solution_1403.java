package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            temp += nums[i];
            res.add(nums[i]);
            if (2 * temp > sum) break;
        }
        return res;
    }
}
