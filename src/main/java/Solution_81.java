package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_81 {
    public boolean search(int[] nums, int target) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList()).contains(target);
    }
}
