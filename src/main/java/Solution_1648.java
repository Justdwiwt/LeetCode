package main.java;

import java.util.Arrays;

public class Solution_1648 {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length, mod = (int) 1e9 + 7;
        int l = 0, r = inventory[n - 1];
        while (l <= r) {
            int mid = (l + r) >> 1;
            long cnt = 0;
            for (int i = n - 1; i > -1; i--) {
                if (inventory[i] < mid || cnt > Integer.MAX_VALUE) break;
                cnt += inventory[i] - mid;
            }
            if (cnt > orders) l = mid + 1;
            else r = mid - 1;
        }
        long cout = 0, res = 0;
        int idx = 0;
        for (int i = n - 1; i > -1; i--) {
            if (inventory[i] < l) break;
            cout += inventory[i] - l;
            res = (res + (long) (inventory[i] + l + 1) * (inventory[i] - l) / 2) % mod;
            idx++;
        }
        long l1 = orders - cout;
        long l2 = l1 / idx;
        res = (res + (idx + 1) * ((l + l - l2 + 1) * l2 / 2)) % mod;
        long l3 = l1 - idx * l2;
        while (l3 > 0) {
            res = (res + l - l2) % mod;
            l3--;
        }
        return (int) res;
    }
}
