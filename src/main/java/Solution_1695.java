package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        IntStream.range(1, nums.length).forEach(i -> preSum[i] = preSum[i - 1] + nums[i]);
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right]) && map.get(nums[right]) >= left)
                left = map.get(nums[right]) + 1;
            sum = Math.max(sum, preSum[right] - (left == 0 ? 0 : preSum[left - 1]));
            map.put(nums[right], right);
        }
        return sum;
    }
}
