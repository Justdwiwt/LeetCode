package main.java;

import java.util.Arrays;

public class Solution_1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int n1 = arr1[0];
        int n2 = arr2[0];
        n1 ^= Arrays.stream(arr1, 1, arr1.length).reduce(0, (a, b) -> a ^ b);
        n2 ^= Arrays.stream(arr2, 1, arr2.length).reduce(0, (a, b) -> a ^ b);
        return n1 & n2;
    }
}
