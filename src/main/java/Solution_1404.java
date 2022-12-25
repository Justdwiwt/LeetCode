package main.java;

public class Solution_1404 {
    public int numSteps(String s) {
        int zero = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '1') i--;
        if (i == 0) return s.length() - 1;
        while (i > 0) if (s.charAt(i--) == '0') zero++;
        return zero + s.length() + 1;
    }
}
