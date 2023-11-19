package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = nums[i], l = i + 1, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < cur) l = mid + 1;
                else r = mid;
            }
            res.add(0, l - i - 1);
            System.arraycopy(nums, i + 1, nums, i, l - i - 1);
            nums[l - 1] = cur;
        }
        return res;
    }
}
