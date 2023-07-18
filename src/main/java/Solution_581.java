package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_581 {
    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        List<Integer> list = IntStream.range(0, nums.length).filter(i -> arr[i] != nums[i]).boxed().collect(Collectors.toList());
        return list.size() == 0 ? 0 : list.get(list.size() - 1) - list.get(0) + 1;
    }
}
