package main.java;

import java.util.Arrays;

public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int[] res = Arrays.stream(nums)
                .filter(n -> n != val)
                .toArray();
        System.arraycopy(res, 0, nums, 0, res.length);
        return res.length;
    }
}
