package main.java;

public class Solution_1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        final int M = 1000000007;
        long preSum = 0, preMax = 0, sufSum = 0, sufMax = 0, curSum = 0, curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            preMax = Math.max(preMax, preSum);
            sufSum += arr[arr.length - 1 - i];
            sufMax = Math.max(sufSum, sufMax);
            curSum = arr[i] + Math.max(0, curSum);
            curMax = Math.max(curSum, curMax);
        }
        return k == 1 ? (int) curMax : (int) (Math.max(curMax, (preMax + sufMax + Math.max(0, preSum) * (k - 2))) % M);
    }
}
