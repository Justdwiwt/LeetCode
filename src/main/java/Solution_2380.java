package main.java;

public class Solution_2380 {
    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        while (s.contains("01")) {
            res++;
            s = s.replace("01", "10");
        }
        return res;
    }
}
