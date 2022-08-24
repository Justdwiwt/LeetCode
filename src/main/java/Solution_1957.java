package main.java;

public class Solution_1957 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        if (s.length() > 1) sb.append(s.charAt(1));
        for (int i = 2, j = 2; i < s.length(); i++)
            if (sb.charAt(j - 1) != s.charAt(i) || sb.charAt(j - 2) != s.charAt(i)) {
                sb.append(s.charAt(i));
                j++;
            }
        return sb.toString();
    }
}
