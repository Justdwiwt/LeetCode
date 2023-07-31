package main.java;

import java.util.stream.IntStream;

public class Solution_522 {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++)
            if (isSpecial(i, strs)) res = Math.max(res, strs[i].length());
        return res;
    }

    private boolean isSpecial(int i, String[] strs) {
        return IntStream.range(0, strs.length).filter(j -> i != j).noneMatch(j -> isSubsequence(strs[i], strs[j]));
    }

    private boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
}
