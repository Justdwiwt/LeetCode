package main.java;

public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0, n = gas.length;
        int begin = 0;
        for (int i = 0; i < n; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                begin = i + 1;
                curSum = 0;
            }
        }
        return totalSum < 0 ? -1 : begin;
    }
}
