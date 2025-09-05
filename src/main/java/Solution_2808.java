package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2808 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, nums.size()).forEach(i -> {
            List<Integer> list = map.computeIfAbsent(nums.get(i), k -> new ArrayList<>());
            list.add(i);
        });
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            int max = n - (list.get(list.size() - 1) - list.get(0));
            for (int i = 1; i < list.size(); i++) max = Math.max(max, list.get(i) - list.get(i - 1));
            min = Math.min(max, min);
        }
        return min >> 1;
    }
}
