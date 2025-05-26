package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2615 {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = IntStream.range(0, nums.length).boxed().collect(Collectors.groupingBy(i -> nums[i]));
        long[] result = new long[nums.length];
        for (List<Integer> list : map.values()) {
            long sum = 0, total = list.stream().mapToLong(Long::valueOf).sum();
            for (int i = 0; i < list.size(); i++)
                result[list.get(i)] = (long) list.get(i) * (i - (list.size() - 1 - i)) - sum + (total - (sum += list.get(i)));
        }
        return result;
    }
}
