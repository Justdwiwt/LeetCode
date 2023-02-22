package main.java;

public class Solution_1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0, n = arr1.length;
        int[] sign = {1, -1};
        for (int first : sign)
            for (int second : sign) {
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    int tmp = arr1[i] + first * arr2[i] + second * i;
                    max = Math.max(max, tmp);
                    min = Math.min(min, tmp);
                }
                res = Math.max(res, max - min);
            }
        return res;
    }
}
