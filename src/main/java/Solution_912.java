package main.java;

import java.util.Arrays;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        int OFFSET = 50000;
        int size = 100000;
        int[] count = new int[size + 1];
        Arrays.stream(nums).forEach(x -> count[x + OFFSET]++);
        int idx = 0;
        for (int i = 0; i <= size; i++) {
            if (count[i] <= 0) continue;
            for (int j = 0; j < count[i]; j++) {
                nums[idx] = i - OFFSET;
                idx++;
            }
        }
        return nums;
    }
}
