package main.java;

import java.util.stream.IntStream;

public class Solution_798 {
    public int bestRotation(int[] nums) {
        int val = 0, n = nums.length;
        int[] moveCurVal2ValIdxStep = new int[n];
        IntStream.range(0, n).forEach(i -> {
            if (nums[i] > i) moveCurVal2ValIdxStep[i + n - nums[i]]++;
            else moveCurVal2ValIdxStep[i - nums[i]]++;
        });
        int k = 0, maxVal = val;
        for (int i = 1; i < n; i++) {
            val = val - moveCurVal2ValIdxStep[i - 1] + 1;
            if (val > maxVal) {
                maxVal = val;
                k = i;
            }
        }
        return k;
    }
}
