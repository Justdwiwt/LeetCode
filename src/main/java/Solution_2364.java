package main.java;

import java.util.HashMap;

public class Solution_2364 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int prev = map.getOrDefault(i - nums[i], 0);
            count += i - prev;
            map.put(i - nums[i], prev + 1);
        }
        return count;
    }
}
