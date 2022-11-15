package main.java;

public class Solution_1578 {
    public int minCost(String s, int[] cost) {
        int minCost = 0;
        int len = s.length();
        for (int i = 1; i < len; ++i)
            if (s.charAt(i) == s.charAt(i - 1)) {
                minCost += Math.min(cost[i - 1], cost[i]);
                cost[i] = Math.max(cost[i - 1], cost[i]);
            }
        return minCost;
    }
}