package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_525 {
    public int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        IntStream.range(0, nums.length).filter(i -> nums[i] == 0).forEach(i -> nums[i] = -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 && i > res) res = i + 1;
            if (map.containsKey(sum)) res = Math.max(i - map.get(sum), res);
            else map.put(sum, i);
        }
        return res;
    }
}
