package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_982 {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> andCntMap = new HashMap<>();
        IntStream.range(0, nums.length).forEach(i -> {
            for (int num : nums) {
                int and = nums[i] & num;
                andCntMap.put(and, andCntMap.getOrDefault(and, 0) + 1);
            }
        });
        int res = 0;
        for (int and : andCntMap.keySet()) {
            int cnt = andCntMap.get(and);
            res += Arrays.stream(nums).filter(num -> (and & num) == 0).map(num -> cnt).sum();
        }
        return res;
    }
}
