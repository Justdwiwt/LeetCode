package main.java;

import java.util.stream.IntStream;

public class Solution_1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < i; j++)
                index[j] += index[j] >= index[i] ? 1 : 0;
        IntStream.range(0, len).forEach(i -> res[index[i]] = nums[i]);
        return res;
    }
}
