package main.java;

import java.util.Arrays;

public class Solution_2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 1, right = price[price.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (satisfy(price, k, mid)) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

    boolean satisfy(int[] price, int k, int bound) {
        int cnt = 1, pre = price[0];
        for (int x : price)
            if (x >= pre + bound) {
                cnt++;
                pre = x;
                if (cnt >= k) return true;
            }
        return false;
    }
}
