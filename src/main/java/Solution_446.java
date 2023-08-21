package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        Map<Long, Integer>[] mapArr = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                map.put(diff, map.getOrDefault(diff, 0) + mapArr[j].getOrDefault(diff, 0) + 1);
                res += mapArr[j].getOrDefault(diff, 0);
            }
            mapArr[i] = map;
        }
        return res;
    }
}
