package main.java;

import java.util.Arrays;

public class Solution_2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > money ? money : money - (prices[0] + prices[1]);
    }
}
