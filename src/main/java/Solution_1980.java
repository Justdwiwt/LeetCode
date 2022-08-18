package main.java;

import java.util.stream.IntStream;

public class Solution_1980 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, nums.length).forEach(i -> {
            String s = nums[i];
            int num = s.charAt(i) - '0';
            sb.append(num ^ 1);
        });
        return sb.toString();
    }
}
