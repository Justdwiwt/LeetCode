package main.java;

import java.util.List;

public class Solution_2861 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int l = 0, r = (int) 2e8, mid = r >> 1;
        while (l < r) {
            boolean f = false;
            for (List<Integer> list : composition) {
                long bud = 0;
                for (int i = 0; i < n; i++) {
                    long u = (long) mid * list.get(i) - stock.get(i);
                    if (u > 0) bud += cost.get(i) * u;
                    if (bud > budget) break;
                }
                if (bud <= budget) {
                    f = true;
                    break;
                }
            }
            if (f) l = mid;
            else r = mid - 1;
            mid = l + ((r - l + 1) >> 1);
        }
        return l;
    }
}
