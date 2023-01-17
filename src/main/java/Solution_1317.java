package main.java;

public class Solution_1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i < n; i++)
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                res[0] = i;
                res[1] = n - i;
                return res;
            }
        return res;
    }
}
