package main.java;

import java.util.Map;
import java.util.TreeMap;

public class Solution_2926 {
    public long maxBalancedSubsequenceSum(int[] nums) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        long max = (long) nums[0];
        for (int num : nums) max = Math.max(num, max);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            Map.Entry<Integer, Long> entry = map.floorEntry(nums[i] - i);
            if (entry != null) {
                map.put(nums[i] - i, entry.getValue() + nums[i]);
                max = Math.max(max, entry.getValue() + nums[i]);
            } else {
                map.put(nums[i] - i, (long) nums[i]);
                max = Math.max(max, nums[i]);
            }
            Map.Entry<Integer, Long> node = map.ceilingEntry(nums[i] - i + 1);
            while (node != null && node.getValue() <= map.get(nums[i] - i)) {
                map.remove(node.getKey());
                node = map.ceilingEntry(nums[i] - i + 1);
            }
        }
        return max;
    }
}
