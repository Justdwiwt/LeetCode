package main.java;

public class Solution_2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long s = 0;
        int[] a = new int[n + n];
        for (int i = 0; i < n; i++) {
            a[i] = a[i + n] = nums[i];
            s += a[i];
        }

        long ans = -1;
        long t = target % s, d = target / s, curs = 0;
        for (int i = 0, j = 0; i < n + n; i++) {
            curs += a[i];
            while (curs > t) curs -= a[j++];
            if (curs == t) {
                long len = i - j + 1 + d * n;
                if (d == 0 || i >= n)
                    if (ans == -1 || len < ans) ans = len;
            }
        }

        return (int) ans;
    }
}
