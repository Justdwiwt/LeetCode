package main.java;

import java.util.Arrays;

public class Solution_2160 {
    public int minimumSum(int num) {
        int[] arr = {num % 10, (num / 10) % 10, (num / 100) % 10, (num / 1000) % 10};
        Arrays.sort(arr);
        return arr[0] * 10 + arr[3] + arr[1] * 10 + arr[2];
    }
}
