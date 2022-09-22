package main.java;

public class Solution_1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int length = nums1.length;
        long res = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            res = res + abs;
            if (max >= abs) continue;
            int tmp = 0;
            for (int k : nums1) {
                int t = Math.abs(k - nums2[i]);
                if (abs - t > tmp) tmp = abs - t;
            }
            max = Math.max(tmp, max);
        }
        return (int) ((res - max) % 1000000007);
    }
}
