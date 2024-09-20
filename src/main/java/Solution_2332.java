package main.java;

import java.util.Arrays;

public class Solution_2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0, res = 0;
        while (i < buses.length) {
            int k = capacity;
            while (k > 0 && j < passengers.length && passengers[j] <= buses[i]) {
                if (passengers[j] - (j == 0 ? 0 : passengers[j - 1]) > 1)
                    res = passengers[j] - 1;
                k--;
                j++;
            }
            if (k > 0 && (j == 0 ? 0 : passengers[j - 1]) < buses[i])
                res = buses[i];
            i++;
        }
        return res;
    }
}
