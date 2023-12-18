package main.java;

import java.util.Arrays;

public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        int lowb = sum & (-sum);
        int num1 = 0, num2 = 0;
        for (int num : nums)
            if ((num & lowb) == 0) num1 ^= num;
            else num2 ^= num;
        return new int[]{num1, num2};
    }
}
