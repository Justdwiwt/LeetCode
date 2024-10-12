package main.java;

public class Solution_2358 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int res = 0;
        while (n > res) n -= (++res);
        return res;
    }
}
