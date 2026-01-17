package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2996 {
    public int missingInteger(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) sum += nums[i];
        while (set.contains(sum)) sum++;
        return sum;
    }
}
