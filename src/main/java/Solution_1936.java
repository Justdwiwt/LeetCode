package main.java;

public class Solution_1936 {
    public int addRungs(int[] rungs, int dist) {
        int res = 0, pre = 0;
        for (int i : rungs) {
            res += (i - pre - 1) / dist;
            pre = i;
        }
        return res;
    }
}
