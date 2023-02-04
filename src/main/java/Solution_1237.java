package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1237 {
    static class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction fun, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int f = fun.f(x, y);
            if (f > z) --y;
            else if (f < z) ++x;
            else res.add(Arrays.asList(x++, y--));
        }
        return res;
    }
}
