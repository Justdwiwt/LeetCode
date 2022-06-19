package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_2249 {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for (int[] circle : circles)
            for (int x = circle[0] - circle[2]; x <= (circle[0] + circle[2]); x++) {
                int v = circle[2] * circle[2];
                for (int y = circle[1] - circle[2]; y <= (circle[1] + circle[2]); y++) {
                    int v1 = Math.abs(x - circle[0]) * Math.abs(x - circle[0]) +
                            Math.abs(y - circle[1]) * Math.abs(y - circle[1]);
                    if (v1 <= v) set.add(x + "," + y);
                }
            }
        return set.size();
    }
}
