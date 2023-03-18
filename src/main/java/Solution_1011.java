package main.java;

public class Solution_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0, max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        int left = Math.max(max, (sum + D - 1) / D), right = sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(weights, mid, D)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] weights, int load, int days) {
        int N = weights.length, idx = 0;
        for (int i = 1; i <= days; i++) {
            int sum = 0;
            while (idx < N && sum + weights[idx] <= load) {
                sum += weights[idx];
                idx++;
            }
            if (idx >= N) break;
        }
        return idx >= N;
    }
}
