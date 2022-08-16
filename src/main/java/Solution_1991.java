package main.java;

import java.util.Arrays;

public class Solution_1991 {
    public int findMiddleIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int frontSum = 0;
        for (int i = 0; i < nums.length; i++)
            if (frontSum == sum - frontSum - nums[i]) return i;
            else frontSum = frontSum + nums[i];
        return -1;
    }
}
