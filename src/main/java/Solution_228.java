package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        int j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++)
            if (nums[i] - 1 > nums[i - 1]) {
                list.add(j == i - 1 ? String.valueOf(nums[j]) : nums[j] + "->" + nums[i - 1]);
                j = i;
            }
        if (j < nums.length)
            list.add(j == nums.length - 1 ? String.valueOf(nums[j]) : nums[j] + "->" + nums[nums.length - 1]);
        return list;
    }
}
