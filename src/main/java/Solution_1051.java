package main.java;

import java.util.Arrays;

public class Solution_1051 {
    public int heightChecker(int[] heights) {
        int[] nums = new int[101];
        Arrays.stream(heights).forEach(num -> nums[num] += 1);
        int res = 0, index = 0;
        for (int i = 1; i < 101; i++)
            for (int j = 0; j < nums[i]; j++)
                if (heights[index++] != i) res++;
        return res;
    }
}
