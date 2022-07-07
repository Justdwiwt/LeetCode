package main.java;

public class Solution_2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int res = Integer.MAX_VALUE, mn = targetSeconds / 60, secs = targetSeconds % 60;
        if (mn > 0 && secs < 40)
            res = cost(startAt, moveCost, pushCost, mn - 1, secs + 60);
        if (mn < 100)
            res = Math.min(res, cost(startAt, moveCost, pushCost, mn, secs));
        return res;
    }

    private int cost(int startAt, int moveCost, int pushCost, int mins, int secs) {
        int idx = 0, res = 0;
        int[] diff = {mins / 10, mins % 10, secs / 10, secs % 10};
        while (diff[idx] == 0) idx++;
        for (int curr = startAt; idx < 4; curr = diff[idx++])
            res += pushCost + (diff[idx] != curr ? moveCost : 0);
        return res;
    }
}
