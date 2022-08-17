package main.java;

public class Solution_1987 {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final long M = (long) 1e9 + 7;
        long end0 = 0, end1 = 0, has0 = 0;
        for (char c : binary.toCharArray())
            if (c == '1') end1 = (end0 + end1 + 1) % M;
            else {
                end0 = (end0 + end1) % M;
                has0 = 1;
            }
        long res;
        res = (end0 + end1 + has0) % M;
        return (int) res;
    }
}
