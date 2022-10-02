package main.java;

import java.util.Arrays;

public class Solution_1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int cur = 0;
        int left = 0;
        while (left < nums.length && cur < groups.length) {
            int[] tmp = new int[groups[cur].length];
            if (left + tmp.length > nums.length)
                break;
            System.arraycopy(nums, left, tmp, 0, tmp.length);
            if (Arrays.equals(tmp, groups[cur])) {
                cur++;
                left += tmp.length;
                continue;
            }
            left++;
        }
        return cur == groups.length;
    }
}
