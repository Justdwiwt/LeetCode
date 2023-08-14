package main.java;

public class Solution_466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int[] cnts = new int[cs2.length + 1], idxs = new int[cs2.length + 1];
        int cnt = 0, idx = 0;
        for (int i = 0; i <= cs2.length; ++i) {
            for (char c : cs1)
                if (c == cs2[idx] && ++idx == cs2.length) {
                    ++cnt;
                    idx = 0;
                }
            cnts[i] = cnt;
            idxs[i] = idx;
            for (int k = 0; k < i; ++k)
                if (idxs[k] == idx) {
                    int p1, p2, p3;
                    p1 = cnts[k];
                    p2 = (cnts[i] - cnts[k]) * ((n1 - 1 - k) / (i - k));
                    p3 = cnts[k + (n1 - 1 - k) % (i - k)] - cnts[k];
                    return (p1 + p2 + p3) / n2;
                }
        }
        return 0;
    }
}
