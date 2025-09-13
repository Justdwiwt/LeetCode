package main.java;

import java.util.List;
import java.util.TreeSet;

public class Solution_2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int result = Integer.MAX_VALUE;
        for (int left = 0, right = x; right < nums.size(); left++, right++) {
            set.add(nums.get(left));
            Integer floor = set.floor(nums.get(right));
            if (floor != null) result = Math.min(result, nums.get(right) - floor);
            Integer ceiling = set.ceiling(nums.get(right));
            if (ceiling != null) result = Math.min(result, ceiling - nums.get(right));
        }
        return result;
    }
}
