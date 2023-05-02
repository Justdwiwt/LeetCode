package main.java;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_874 {
    private final int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pair<Integer, Integer>> set;
        int curDir = 3, x = 0, y = 0, res = 0;
        set = Arrays.stream(obstacles).map(ob -> new Pair<>(ob[0], ob[1])).collect(Collectors.toSet());
        for (int command : commands)
            if (command == -2) curDir = (curDir + 3) % 4;
            else if (command == -1) curDir = (curDir + 1) % 4;
            else for (int i = 1; i <= command; i++) {
                    int nx = x + dirs[curDir][0], ny = y + dirs[curDir][1];
                    if (!set.contains(new Pair<>(nx, ny))) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
        return res;
    }
}
