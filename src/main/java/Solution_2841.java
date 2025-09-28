package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0L, sum = 0L;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
            if (i >= k) {
                Integer pre = nums.get(i - k);
                map.put(pre, map.getOrDefault(pre, 0) - 1);
                if (map.get(pre) == 0) {
                    map.remove(pre);
                }
                sum -= pre;
            }
            if (i + 1 >= k && map.size() >= m) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
