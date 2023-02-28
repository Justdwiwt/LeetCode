package main.java;

public class Solution_1093 {
    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        long cnt = 0;
        int mode = 0;
        for (int i = 0; i < 256; i++)
            if (count[i] > 0) {
                min = Math.min(i, min);
                max = Math.max(i, max);
                sum += (long) count[i] * (long) i;
                cnt += count[i];
                if (count[i] > count[mode]) mode = i;
            }
        double median = 0;
        if (cnt % 2 == 1) {
            long mid = cnt / 2;
            for (int i = 0; i < 256; i++) {
                if (mid - count[i] < 0) {
                    median = i;
                    break;
                }
                mid -= count[i];
            }
        } else {
            long left = (cnt - 1) / 2;
            long right = cnt / 2;
            int leftVal = -1;
            int rightVal = -1;
            for (int i = 0; i < 256; i++) {
                if (leftVal == -1 && (left - count[i] < 0)) leftVal = i;
                if (rightVal == -1 && (right - count[i] < 0)) rightVal = i;
                if (leftVal > 0 && rightVal > 0) break;
                left -= count[i];
                right -= count[i];
            }
            median = 0.5 * (leftVal + rightVal);
        }
        return new double[]{min, max, sum / (double) cnt, median, mode};
    }
}
