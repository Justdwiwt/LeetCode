package main.java;

public class Solution_1614 {
    public int maxDepth(String s) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(') {
                cnt++;
                max = Math.max(max, cnt);
            } else if (s.charAt(i) == ')') cnt--;
        return max;
    }
}
