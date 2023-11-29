package main.java;

import java.util.Arrays;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, res = 0;
        int[] arr = new int[len];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int num : nums) {
            int i = 0, j = len - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (arr[mid] < num) i = mid + 1;
                else j = mid - 1;
            }
            arr[i] = num;
            if (arr[res] != Integer.MAX_VALUE) res++;
        }
        return res;
    }
}
