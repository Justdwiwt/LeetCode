package main.java;

public class Solution_1562 {
    public int findLatestStep(int[] A, int m) {
        int res = -1, n = A.length;
        int[] length = new int[n + 2], cnt = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = A[i], left = length[a - 1], right = length[a + 1];
            length[a] = length[a - left] = length[a + right] = left + right + 1;
            cnt[left]--;
            cnt[right]--;
            cnt[length[a]]++;
            if (cnt[m] > 0) res = i + 1;
        }
        return res;
    }
}
