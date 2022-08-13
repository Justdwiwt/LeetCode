package main.java;

import java.util.HashMap;

public class Solution_2006 {
    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            cnt += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
            map.compute(num, (n, v) -> v == null ? 1 : v + 1);
        }
        return cnt;
    }
}
