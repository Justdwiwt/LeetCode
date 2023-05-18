package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Integer> sales = new ArrayList<>();
        for (int k : worker) {
            int maxSales = 0;
            for (int j = 0; j < difficulty.length; j++)
                if (k >= difficulty[j] && profit[j] >= maxSales) maxSales = profit[j];
            sales.add(maxSales);
        }
        return sales.stream().mapToInt(sale -> sale).sum();
    }
}
