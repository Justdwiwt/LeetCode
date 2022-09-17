package main.java;

import java.util.Arrays;

public class Solution_1840 {
    public static int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        int res = 0, b = -1;
        for (int[] restriction : restrictions)
            if (restriction[1] - restriction[0] < b) {
                res = Math.max(res, (restriction[0] + restriction[1] + b) >>> 1);
                b = restriction[1] - restriction[0];
            }
        return Math.max(res, n + b);
    }
}
