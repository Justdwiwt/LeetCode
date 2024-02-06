package main.java;

import java.util.stream.IntStream;

public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        IntStream.range(0, n).forEach(i -> newArr[(i + k) % n] = nums[i]);
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
