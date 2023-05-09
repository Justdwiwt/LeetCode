package main.java;

public class Solution_854 {
    int result = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int count = 0, len = cs1.length;
        for (int p = 0; p < len; p++) {
            if (cs1[p] == cs2[p]) continue;
            int q = p;
            while (++q < len) {
                if (cs1[p] == cs2[q] && cs1[q] == cs2[p]) {
                    swap(cs2, p, q);
                    count++;
                    break;
                }
            }
        }
        execute(cs1, cs2, 0, 0);
        return count + result;
    }

    public void execute(char[] cs1, char[] cs2, int start, int ans) {
        while (start < cs1.length && cs1[start] == cs2[start]) start++;
        if (start == cs1.length && ans < result) result = ans;
        for (int i = start + 1; i < cs2.length; i++)
            if (cs2[i] == cs1[start] && cs1[i] != cs2[i]) {
                swap(cs2, start, i);
                execute(cs1, cs2, start + 1, ans + 1);
                swap(cs2, i, start);
            }
    }

    public void swap(char[] cs, int p1, int p2) {
        char c = cs[p1];
        cs[p1] = cs[p2];
        cs[p2] = c;
    }
}
