package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2342 {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int res = -1, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int x = nums[i]; x > 0; x /= 10)
                sum += x % 10;
            if (map.containsKey(sum)) res = Math.max(res, map.get(sum) + nums[i]);
            else map.put(sum, nums[i]);
        }
        return res;
    }
}
