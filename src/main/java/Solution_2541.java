package main.java;

public class Solution_2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long n = nums1.length;
        long sum = 0;
        long op = 0;
        for (int i = 0; i < n; i++) {
            long diff = nums1[i] - nums2[i];
            if (diff == 0) continue;
            double divisor = (double) diff / k;
            if (divisor != (long) divisor) return -1;
            op += (long) divisor;
            sum += Math.abs(diff);
        }
        if (k == 0) return sum != 0 ? -1 : 0;
        return op != 0 ? -1 : sum / (k * 2L);
    }
}
