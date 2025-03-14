package main.java;

import java.util.Arrays;

public class Solution_2535 {
    public int differenceOfSum(int[] nums) {
        return Arrays.stream(nums).map(num -> (num - bitSum(num))).sum();
    }

    public int bitSum(int num) {
        return num == 0 ? 0 : (num % 10) + bitSum(num / 10);
    }
}
