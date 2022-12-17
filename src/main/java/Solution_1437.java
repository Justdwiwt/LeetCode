package main.java;

public class Solution_1437 {
    public boolean kLengthApart(int[] a, int k) {
        for (int i = 0, pre = ++k * (-1); i < a.length; i++)
            if (a[i] == 1) {
                if (i - pre < k) return false;
                pre = i;
            }
        return true;
    }
}
