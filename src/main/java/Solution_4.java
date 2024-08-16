package main.java;

public class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int cnt = (n1 + n2 + 1) / 2;
        int left = 0, right = n1;
        while (left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = cnt - mid1 - 1;
            if (nums1[mid1] >= nums2[mid2]) right = mid1;
            else left = mid1 + 1;
        }
        int cnt1 = left, cnt2 = cnt - left;
        int leftVal = Math.max(cnt1 == 0 ? Integer.MIN_VALUE : nums1[cnt1 - 1], cnt2 == 0 ? Integer.MIN_VALUE : nums2[cnt2 - 1]);
        if ((n1 + n2) % 2 == 1) return leftVal;
        int rightVal = Math.min(cnt1 == n1 ? Integer.MAX_VALUE : nums1[cnt1], cnt2 == n2 ? Integer.MAX_VALUE : nums2[cnt2]);
        return (leftVal + rightVal) / 2.0;
    }
}
