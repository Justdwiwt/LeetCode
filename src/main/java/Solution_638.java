package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_638 {
    private List<List<Integer>> special;
    private List<Integer> prices;

    private int res = 0;

    public int shoppingOffers(List<Integer> prices, List<List<Integer>> special, List<Integer> needs) {
        this.special = special;
        this.prices = prices;
        IntStream.range(0, needs.size()).forEach(i -> res += (needs.get(i) * prices.get(i)));
        dfs(0, needs, 0);
        return res;
    }

    private void dfs(int d, List<Integer> needs, int price) {
        for (int i = d; i < special.size(); i++) {
            List<Integer> sp = special.get(i);
            boolean check = check(needs, sp);
            Integer total = sp.get(needs.size());
            if (!check || res < total) continue;
            IntStream.range(0, needs.size()).forEach(j -> needs.set(j, needs.get(j) - sp.get(j)));
            dfs(i, needs, price + total);
            IntStream.range(0, needs.size()).forEach(j -> needs.set(j, needs.get(j) + sp.get(j)));
        }

        price += IntStream.range(0, needs.size()).map(i -> (needs.get(i) * prices.get(i))).sum();
        res = Math.min(price, res);
    }

    private boolean check(List<Integer> needs, List<Integer> special) {
        return IntStream.range(0, needs.size()).noneMatch(i -> needs.get(i) < special.get(i));
    }
}
