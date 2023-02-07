package main.java;

public class Solution_1220 {
    public int countVowelPermutation(int n) {
        final int M = 1000000007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        while (--n > 0) {
            long na, ne, ni, no, nu;
            ne = (a + i) % M;
            na = (e + i + u) % M;
            ni = (e + o) % M;
            no = i;
            nu = (i + o) % M;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return (int) ((((a + e) % M + i) % M + u) % M + o) % M;
    }
}
