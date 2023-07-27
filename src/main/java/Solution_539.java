package main.java;

import java.util.Arrays;
import java.util.List;

public class Solution_539 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = timePoints.stream().mapToInt(timePoint -> Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3))).toArray();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) min = Math.min(min, arr[i] - arr[i - 1]);
        return Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);
    }
}
