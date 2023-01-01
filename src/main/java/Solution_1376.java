package main.java;

public class Solution_1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] != 0) continue;
            int sum = 0, cur = i;
            while (manager[cur] != -1) {
                sum += informTime[manager[cur]];
                cur = manager[cur];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
