package main.java;

public class Solution_2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums1)
            if (num != 0) sum1 += num;
            else cnt1++;
        for (int num : nums2)
            if (num != 0) sum2 += num;
            else cnt2++;
        return (cnt1 == 0 && sum1 < sum2 + cnt2) || (cnt2 == 0 && sum2 < sum1 + cnt1) ? -1 : Math.max(sum1 + cnt1, sum2 + cnt2);
    }
}
