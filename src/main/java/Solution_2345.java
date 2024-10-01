package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2345 {
    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        List<int[]> arr = new ArrayList<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int[] peak : peaks) {
            arr.add(new int[]{peak[0] - peak[1], peak[0] + peak[1]});
            left = Math.min(left, peak[0] - peak[1]);
            right = Math.max(right, peak[0] + peak[1]);
        }
        arr.sort((x, y) -> x[0] != y[0] ? (x[0] - y[0]) : ((y[1] - y[0]) - (x[1] - x[0])));
        int count = 0;
        int current = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr.get(i)[1] <= current)
                continue;
            current = Math.max(arr.get(i)[1], current);
            count++;
            if (i < n - 1 && arr.get(i)[0] == arr.get(i + 1)[0] && arr.get(i)[1] == arr.get(i + 1)[1])
                count--;
            if (current >= right)
                break;
        }
        return count;
    }
}
