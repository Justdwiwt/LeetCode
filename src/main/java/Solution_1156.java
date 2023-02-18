package main.java;

public class Solution_1156 {
    public int maxRepOpt1(String text) {
        int res = 0;
        int[] tot = new int[26];
        for (char c : text.toCharArray()) tot[c - 'a']++;
        for (char c = 'a'; c <= 'z'; c++) {
            int i = text.indexOf(c);
            if (i == -1) continue;
            for (int j = i, p = -1; j < text.length(); j++) {
                if (text.charAt(j) != c) {
                    if (i <= p && p < j) i = p + 1;
                    p = j;
                }
                if (i <= p && p <= j && tot[c - 'a'] <= j - i) continue;
                res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}
