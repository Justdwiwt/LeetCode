package main.java;

import java.util.stream.IntStream;

public class Solution_1232 {
    public boolean checkStraightLine(int[][] co) {
        return IntStream.range(2, co.length).noneMatch(i -> (co[1][1] - co[0][1]) * (co[i][0] - co[0][0]) != (co[i][1] - co[0][1]) * (co[1][0] - co[0][0]));
    }
}
