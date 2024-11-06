package main.java;

public class Solution_2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int stars = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') stars++;
            else if (stars > 0) stars--;
            else sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
