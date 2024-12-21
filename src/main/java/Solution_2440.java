package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2440 {
    public int componentValue(int[] nums, int[][] edges) {
        int sum;
        int n = nums.length;
        sum = Arrays.stream(nums, 0, n).sum();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        IntStream.range(0, edges.length).forEach(i -> {
            if (!map.containsKey(edges[i][0])) map.put(edges[i][0], new HashSet<>());
            if (!map.containsKey(edges[i][1])) map.put(edges[i][1], new HashSet<>());
            map.get(edges[i][1]).add(edges[i][0]);
            map.get(edges[i][0]).add(edges[i][1]);
        });
        for (int i = n; i > 1; i--)
            if (sum % i == 0 && cal(map, 0, -1, sum / i, nums) == 0) return i - 1;
        return 0;
    }

    public int cal(Map<Integer, Set<Integer>> map, int curr, int pre, int target, int[] nums) {
        int val = nums[curr];
        Set<Integer> next = map.get(curr);
        int temp;
        for (Integer i : next) {
            if (i == pre) continue;
            temp = cal(map, i, curr, target, nums);
            if (temp == -1) return -1;
            val += temp;
        }
        return val == target ? 0 : val > target ? -1 : val;
    }
}
