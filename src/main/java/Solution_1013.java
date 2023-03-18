package main.java;

import java.util.Arrays;

public class Solution_1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int N = arr.length;
        int sum = Arrays.stream(arr, 0, N).sum();
        if (sum % 3 != 0) return false;
        int average = sum / 3;
        int s = 0;
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum == average) {
                s++;
                if (s == 2 && i != N - 1) return true;
                sum = 0;
            }
        }
        return false;
    }
}
