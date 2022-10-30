package main.java;

import java.util.Arrays;

public class Solution_1649 {
    public int createSortedArray(int[] instructions) {
        int max = Arrays.stream(instructions).max().orElse(-1);
        BIT bit = new BIT(max);
        int cnt = 0;
        long res = 0;
        for (int in : instructions) {
            int min = bit.query(in - 1);
            int num = bit.query(in) - min;
            bit.add(in, 1);
            res += Math.min(min, cnt - min - num);
            cnt++;
        }
        return (int) (res % 1000000007);
    }
}

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowBit(int x) {
        return x & (-x);
    }

    public void add(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowBit(x);
        }
    }

    public int query(int x) {
        int res = 0;
        while (x != 0) {
            res += tree[x];
            x -= lowBit(x);
        }
        return res;
    }
}
