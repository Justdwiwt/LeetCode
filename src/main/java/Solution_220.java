package main.java;

import java.util.TreeSet;

public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) return true;
            set.add((long) nums[i]);
            if (set.size() == k + 1) set.remove((long) nums[i - k]);
        }
        return false;
    }
}
