package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2983 {
    public boolean[] canMakePalindromeQueries(String S, int[][] queries) {
        char[] s = S.toCharArray();
        int m = s.length;
        int n = m / 2;

        int[][] sumS = new int[n + 1][26];
        IntStream.range(0, n).forEach(i -> {
            sumS[i + 1] = sumS[i].clone();
            sumS[i + 1][s[i] - 'a']++;
        });

        int[][] sumT = new int[n + 1][26];
        IntStream.range(0, n).forEach(i -> {
            sumT[i + 1] = sumT[i].clone();
            sumT[i + 1][s[m - 1 - i] - 'a']++;
        });

        int[] sumNe = new int[n + 1];
        IntStream.range(0, n).forEach(i -> sumNe[i + 1] = sumNe[i] + (s[i] != s[m - 1 - i] ? 1 : 0));

        boolean[] ans = new boolean[queries.length];
        IntStream.range(0, queries.length).forEach(i -> {
            int[] q = queries[i];
            int l1 = q[0], r1 = q[1], l2 = m - 1 - q[3], r2 = m - 1 - q[2];
            ans[i] = l1 <= l2 ? check(l1, r1, l2, r2, sumS, sumT, sumNe) :
                    check(l2, r2, l1, r1, sumT, sumS, sumNe);
        });
        return ans;
    }

    private boolean check(int l1, int r1, int l2, int r2, int[][] sumS, int[][] sumT, int[] sumNe) {
        if (sumNe[l1] > 0 ||
                sumNe[sumNe.length - 1] - sumNe[Math.max(r1, r2) + 1] > 0) return false;
        if (r2 <= r1) return Arrays.equals(count(sumS, l1, r1), count(sumT, l1, r1));
        if (r1 < l2) return sumNe[l2] - sumNe[r1 + 1] <= 0 &&
                Arrays.equals(count(sumS, l1, r1), count(sumT, l1, r1)) &&
                Arrays.equals(count(sumS, l2, r2), count(sumT, l2, r2));
        int[] s1 = subtract(count(sumS, l1, r1), count(sumT, l1, l2 - 1));
        int[] s2 = subtract(count(sumT, l2, r2), count(sumS, r1 + 1, r2));
        return s1 != null && s2 != null && Arrays.equals(s1, s2);
    }


    private int[] count(int[][] sum, int l, int r) {
        int[] res = sum[r + 1].clone();
        IntStream.range(0, 26).forEach(i -> res[i] -= sum[l][i]);
        return res;
    }

    private int[] subtract(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            s1[i] -= s2[i];
            if (s1[i] < 0) return null;
        }
        return s1;
    }
}
