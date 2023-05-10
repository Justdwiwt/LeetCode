package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution_850 {
    static final int M = (int) (1e9 + 7);

    public int rectangleArea(int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(rectangles).forEach(rectangle -> {
            set.add(rectangle[1]);
            set.add(rectangle[3]);
        });
        int res = 0;
        Iterator<Integer> iterator = set.iterator();
        int bottom = iterator.next();
        while (iterator.hasNext()) {
            int top = iterator.next();
            res = (res + rectangleArea(rectangles, bottom, top)) % M;
            bottom = top;
        }
        return res;
    }

    private int rectangleArea(int[][] rectangles, int bottom, int top) {
        int h = top - bottom, width = 0;
        for (int i = 0, r = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            if (rectangle[1] <= bottom && rectangle[3] >= top) {
                if (r >= rectangle[0] && r < rectangle[2]) width += rectangle[2] - r;
                else if (r < rectangle[0]) width += rectangle[2] - rectangle[0];
                r = Math.max(r, rectangle[2]);
            }
        }
        return (int) ((long) h * width % M);
    }
}
