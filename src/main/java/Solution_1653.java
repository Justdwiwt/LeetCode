package main.java;

public class Solution_1653 {
    public int minimumDeletions(String s) {
        int cntA = 0;
        int cntB = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') cntA++;
            else cntB++;
            cntA = Math.min(cntA, cntB);
        }
        return cntA;
    }
}
