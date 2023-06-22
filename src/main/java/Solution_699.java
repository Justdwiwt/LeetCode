package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_699 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int[] position : positions) {
            int h = 0;
            for (int[] a : list) {
                if (a[1] <= position[0] || a[0] >= position[0] + position[1]) continue;
                h = Math.max(h, a[2]);
            }
            h += position[1];
            max = Math.max(h, max);
            list.add(new int[]{position[0], position[0] + position[1], h});
            res.add(max);
        }
        return res;
    }
}
