package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1357 {
    static class Cashier {
        int n, discount, cnt;
        Map<Integer, Integer> menu = new HashMap<>();

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            IntStream.range(0, products.length).forEach(i -> menu.put(products[i], prices[i]));
        }

        public double getBill(int[] product, int[] amount) {
            cnt++;
            double res = IntStream.range(0, product.length).mapToDouble(i -> menu.get(product[i]) * amount[i]).sum();
            if (cnt % n == 0) res = res - (discount * res) / 100;
            return res;
        }
    }
}
