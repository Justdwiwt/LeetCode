package main.java;

import java.util.stream.IntStream;

public class Solution_1929 {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        IntStream.range(0, nums.length).forEach(i -> res[i] = res[i + nums.length] = nums[i]);
        return res;
    }
}
