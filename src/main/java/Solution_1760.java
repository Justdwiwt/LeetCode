package main.java;

import java.util.Arrays;

public class Solution_1760 {
    public int minimumSize(int[] nums, int max) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int cnt = Arrays.stream(nums).filter(i -> i > mid).map(i -> (i - 1) / mid).sum();
            if (cnt > max) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
