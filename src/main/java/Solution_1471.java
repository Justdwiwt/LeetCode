package main.java;

import java.util.Arrays;

public class Solution_1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        int left = 0, right = arr.length - 1;
        int mid = arr[right / 2];
        while (k > 0) {
            if (arr[right] - mid >= mid - arr[left])
                res[--k] = arr[right--];
            else res[--k] = arr[left++];
        }
        return res;
    }
}
