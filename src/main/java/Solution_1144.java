package main.java;

public class Solution_1144 {
    public int movesToMakeZigzag(int[] nums) {
        int N = nums.length, p = 0, q = 0;
        for (int i = 0; i < N; i++) {
            int l = i - 1 >= 0 ? nums[i - 1] : nums[i] + 1;
            int r = i + 1 < N ? nums[i + 1] : nums[i] + 1;
            int min = Math.min(l, r);
            if (i % 2 == 0) {
                if (nums[i] >= min) p += nums[i] - min + 1;
            } else if (nums[i] >= min) q += nums[i] - min + 1;
        }
        return Math.min(p, q);
    }
}
