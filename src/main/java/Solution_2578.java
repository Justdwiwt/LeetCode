package main.java;

import java.util.Arrays;

public class Solution_2578 {
    public int splitNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            left = (left * 10) + (arr[i] - '0');
            if (i + 1 < arr.length) {
                right = (right * 10) + (arr[i + 1] - '0');
                i++;
            }
        }
        return left + right;
    }
}
