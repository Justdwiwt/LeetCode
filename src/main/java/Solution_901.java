package main.java;

import java.util.ArrayList;

public class Solution_901 {
    static class StockSpanner {
        ArrayList<int[]> data;

        public StockSpanner() {
            data = new ArrayList<>();
        }

        public int next(int price) {
            int i = data.size() - 1, res = 1;
            int[] item;
            while (i >= 0) {
                item = data.get(i);
                if (item[0] <= price) {
                    i -= item[1];
                    res += item[1];
                } else break;
            }
            data.add(new int[]{price, res});
            return res;
        }
    }
}
