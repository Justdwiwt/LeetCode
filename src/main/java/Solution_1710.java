package main.java;

import java.util.Arrays;

public class Solution_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] == o1[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int sum = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int[] boxType = boxTypes[i];
            sum += Math.min(boxType[0], truckSize) * boxType[1];
            truckSize -= boxType[0];
        }
        return sum;
    }
}
