package main.java;

import java.util.Arrays;

public class Solution_1300 {
    public int findBestValue(int[] arr, int target) {
        int l = target / arr.length, r = 0;
        for (int a : arr) r = Math.max(r, a);
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int s = sum(arr, mid);
            if (s == target) return mid;
            if (s < target) l = mid + 1;
            else r = mid - 1;
        }
        return Math.abs(sum(arr, l) - target) < Math.abs(sum(arr, r) - target) ? l : r;
    }

    public int sum(int[] arr, int max) {
        return Arrays.stream(arr).map(n -> Math.min(n, max)).sum();
    }
}
