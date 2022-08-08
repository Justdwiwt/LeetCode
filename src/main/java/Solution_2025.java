package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2025 {
    public int waysToPartition(int[] nums, int k) {
        int sum = 0, n = nums.length;
        Map<Integer, Integer> prefixCnt = new HashMap<>(), leftPrefixCnt = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            prefixCnt.put(sum, prefixCnt.getOrDefault(sum, 0) + 1);
        }
        sum += nums[n - 1];
        int max = 0;
        if (sum % 2 == 0 && prefixCnt.containsKey(sum / 2))
            max = prefixCnt.get(sum / 2);
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            int diff = k - nums[i];
            if ((sum + diff) % 2 == 0) {
                Integer left = leftPrefixCnt.get((sum + diff) / 2), right = prefixCnt.get((sum - diff) / 2);
                int count = (left == null ? 0 : left) + (right == null ? 0 : right);
                max = Math.max(max, count);
            }
            prefix += nums[i];
            leftPrefixCnt.put(prefix, leftPrefixCnt.getOrDefault(prefix, 0) + 1);
            if (i < n - 1) prefixCnt.put(prefix, prefixCnt.get(prefix) - 1);
        }
        return max;
    }
}
