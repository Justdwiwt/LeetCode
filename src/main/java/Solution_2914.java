package main.java;

public class Solution_2914 {
    public int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) res += s.charAt(i) ^ s.charAt(i + 1);
        return res;
    }
}
