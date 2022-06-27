package main.java;

public class Solution_2210 {
    public int countHillValley(int[] a) {
        int res = 0, left = a[0];
        for (int i = 1; i < a.length - 1; i++)
            if (left < a[i] && a[i] > a[i + 1] || left > a[i] && a[i] < a[i + 1]) {
                res++;
                left = a[i];
            }
        return res;
    }
}
