package main.java;

public class Solution_926 {
    public int minFlipsMonoIncr(String s) {
        int zero = 0, one = 0;
        for (char c : s.toCharArray())
            if (c == '0') one = Math.min(zero, one) + 1;
            else {
                one = Math.min(zero, one);
                zero++;
            }
        return Math.min(zero, one);
    }
}
