package main.java;

public class Solution_1704 {
    public boolean halvesAreAlike(String s) {
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);
        String check = "aeiouAEIOU";
        int idx = 0;
        for (int i = 0; i < left.length(); i++) {
            if (check.indexOf(left.charAt(i)) != -1)
                idx++;
            if (check.indexOf(right.charAt(i)) != -1)
                idx--;
        }
        return idx == 0;
    }
}
