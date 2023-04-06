package main.java;

public class Solution_955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        boolean[] ok = new boolean[n];
        int res = 0;
        for (int j = 0; j < len; j++) {
            boolean delete = false;
            for (int i = 0; i < n - 1; i++) {
                if (ok[i]) continue;
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    delete = true;
                    break;
                }
            }
            if (delete) res++;
            else for (int i = 0; i < n - 1; i++) if (strs[i].charAt(j) < strs[i + 1].charAt(j)) ok[i] = true;
        }
        return res;
    }
}
