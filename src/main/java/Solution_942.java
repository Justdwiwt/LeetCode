package main.java;

public class Solution_942 {
    public int[] diStringMatch(String s) {
        int N = s.length();
        int[] res = new int[N + 1];
        int min = 0, max = N;
        for (int i = 0; i < N; ++i)
            res[i] = s.charAt(i) == 'I' ? min++ : max--;
        res[N] = max;
        return res;
    }
}
