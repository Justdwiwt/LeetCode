package main.java;

public class Solution_1598 {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String s : logs) {
            if (s.equals("../") && cnt != 0) cnt--;
            if (!s.equals("./") && !s.equals("../")) cnt++;
        }
        return cnt;
    }
}
