package main.java;

import java.util.Arrays;

public class Solution_553 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        if (nums.length == 2) return String.join("/", arr);
        arr[1] = "(" + arr[1];
        arr[arr.length - 1] = arr[arr.length - 1] + ")";
        return String.join("/", arr);
    }
}
