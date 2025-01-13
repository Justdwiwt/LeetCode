package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2465 {
    public int distinctAverages(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            set.add(nums[l] + nums[r]);
            ++l;
            --r;
        }
        return set.size();
    }
}
