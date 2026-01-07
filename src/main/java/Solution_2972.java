package main.java;

public class Solution_2972 {
    public long incremovableSubarrayCount(int[] a) {
        int n = a.length;
        int i = 0;
        while (i < n - 1 && a[i] < a[i + 1]) i++;
        if (i == n - 1) return (long) n * (n + 1) / 2;
        long ans = i + 2;
        for (int j = n - 1; j == n - 1 || a[j] < a[j + 1]; j--) {
            while (i >= 0 && a[i] >= a[j]) i--;
            ans += i + 2;
        }
        return ans;
    }
}
