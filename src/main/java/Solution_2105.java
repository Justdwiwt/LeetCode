package main.java;

public class Solution_2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length, res = 0;
        int la = capacityA, lb = capacityB;
        int a = 0, b = n - 1;
        while (a < b) {
            if (la < plants[a]) {
                la = capacityA;
                res++;
            }
            la -= plants[a];
            a++;

            if (lb < plants[b]) {
                lb = capacityB;
                res++;
            }
            lb -= plants[b];
            b--;
        }

        if (a == b && Math.max(la, lb) < plants[a])
            res++;

        return res;
    }
}
