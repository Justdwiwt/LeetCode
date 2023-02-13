package main.java;

public class Solution_1186 {
    public int maximumSum(int[] arr) {
        int a = arr[0], b = arr[0], res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            b = Math.max(a, b + arr[i]);
            a = Math.max(arr[i], arr[i] + a);
            res = Math.max(res, Math.max(a, b));
        }
        return res;
    }
}
