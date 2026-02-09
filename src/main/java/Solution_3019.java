package main.java;

public class Solution_3019 {
    public int countKeyChanges(String s) {
        int flag = -1, n = s.length(), res = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int c = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
            if (c != flag) {
                res++;
                flag = c;
            }
        }
        return res;
    }
}
