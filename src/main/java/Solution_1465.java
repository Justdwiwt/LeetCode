package main.java;

import java.util.Arrays;

public class Solution_1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max1 = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long max2 = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++)
            max1 = Math.max(max1, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < verticalCuts.length; i++)
            max2 = Math.max(max2, verticalCuts[i] - verticalCuts[i - 1]);
        long a = (long) Math.pow(10, 9) + 7;
        return (int) ((max1 * max2) % a);
    }
}
