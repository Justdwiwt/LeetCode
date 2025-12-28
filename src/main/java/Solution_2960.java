package main.java;

public class Solution_2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int cnt = 0;
        for (int batteryPercentage : batteryPercentages)
            if (batteryPercentage - cnt > 0) cnt++;
        return cnt;
    }
}
