package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] poss = new boolean[8][8];
        IntStream.range(0, queens.length).forEach(i -> poss[queens[i][0]][queens[i][1]] = true);
        List<List<Integer>> res = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for (int[] direction : directions) {
            int x = king[0];
            int y = king[1];
            while (x >= 0 && y >= 0 && x < 8 && y < 8)
                if (poss[x][y]) {
                    List<Integer> t = new ArrayList<>();
                    t.add(x);
                    t.add(y);
                    res.add(t);
                    break;
                } else {
                    x += direction[0];
                    y += direction[1];
                }
        }
        return res;
    }
}
