package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2023 {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(str -> map.put(str, map.getOrDefault(str, 0) + 1));
        for (String prefix : nums)
            if (target.startsWith(prefix)) {
                String suffix = target.substring(prefix.length());
                cnt += map.getOrDefault(suffix, 0);
                cnt -= prefix.equals(suffix) ? 1 : 0;
            }
        return cnt;
    }
}
