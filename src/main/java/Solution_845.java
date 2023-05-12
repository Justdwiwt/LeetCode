package main.java;

public class Solution_845 {
    public int longestMountain(int[] A) {
        if (A == null || A.length <= 2) return 0;
        int res = 0;
        for (int i = 1; i < A.length - 1; i++)
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && A[l - 1] < A[l]) l--;
                while (r < A.length - 1 && A[r + 1] < A[r]) r++;
                res = Math.max(res, (r - l + 1));
            }
        return res;
    }
}
