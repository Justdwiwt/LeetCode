package main.java;

public class Solution_2575 {
    public int[] divisibilityArray(String word, int m) {
        long tmp = 0;
        int n = word.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            tmp = (tmp * 10 + word.charAt(i) - '0') % m;
            res[i] = tmp == 0 ? 1 : 0;
        }
        return res;
    }
}
