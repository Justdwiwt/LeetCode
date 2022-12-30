package main.java;

import java.util.stream.IntStream;

public class Solution_1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return (int) IntStream.range(0, arr1.length).filter(i -> isGood(arr1[i], d, arr2)).count();
    }

    private boolean isGood(int a, int d, int arr[]) {
        return IntStream.range(0, arr.length).noneMatch(i -> Math.abs(a - arr[i]) <= d);
    }
}
