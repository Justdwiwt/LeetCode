package main.java;

import java.util.Arrays;

public class Solution_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int cur = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] >= cur + 1) cur++;
        return cur;
    }
}
