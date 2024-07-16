package main.java;

import java.util.Arrays;

public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int answer = Arrays.binarySearch(nums, target);
        return answer >= 0 ? answer : -answer - 1;
    }
}
