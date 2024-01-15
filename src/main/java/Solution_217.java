package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() < nums.length;
    }
}
