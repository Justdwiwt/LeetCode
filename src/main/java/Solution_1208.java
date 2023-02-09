package main.java;

public class Solution_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0, cost = 0;
        while (right < s.length()) {
            cost += Math.abs(s.charAt(right) - t.charAt(right++));
            if (cost > maxCost) cost -= Math.abs(s.charAt(left) - t.charAt(left++));
        }
        return right - left;
    }
}
