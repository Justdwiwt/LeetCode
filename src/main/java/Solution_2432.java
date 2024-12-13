package main.java;

public class Solution_2432 {
    public int hardestWorker(int n, int[][] logs) {
        int[] diff = new int[logs.length];
        diff[0] = logs[0][1];
        int max = diff[0];
        int ans = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            diff[i] = logs[i][1] - logs[i - 1][1];
            if (diff[i] > max || (diff[i] == max && ans > logs[i][0])) {
                max = diff[i];
                ans = logs[i][0];
            }
        }
        return ans;
    }
}
