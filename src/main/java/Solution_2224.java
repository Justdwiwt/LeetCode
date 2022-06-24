package main.java;

public class Solution_2224 {
    static final int[] M = {60, 15, 5, 1};

    public int convertTime(String current, String correct) {
        int diff = parseMinutes(correct) - parseMinutes(current);
        int res = 0;
        for (int m : M) {
            res += diff / m;
            diff %= m;
        }
        return res;
    }

    private int parseMinutes(String s) {
        int minutes = Integer.parseInt(s.substring(0, 2)) * 60;
        minutes += Integer.parseInt(s.substring(3));
        return minutes;
    }
}
