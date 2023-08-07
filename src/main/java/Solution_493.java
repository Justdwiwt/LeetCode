package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_493 {
    public int reversePairs(int[] nums) {
        List<Long> list = new ArrayList<>();
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res += binSearch(list, (long) nums[i]);
            list.add(binSearch(list, (long) nums[i] * 2), (long) nums[i] * 2);
        }
        return res;
    }

    private int binSearch(List<Long> list, long target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) >= target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
