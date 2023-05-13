package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S.toCharArray(), 0, S.length(), res);
        return res;
    }

    private boolean dfs(char[] s, int begin, int end, List<Integer> res) {
        if (begin == end) return res.size() > 2;
        long num = 0;
        for (int i = begin; i < end; i++) {
            num = num * 10 + (s[i] - '0');
            if (i == begin + 1 && s[begin] == '0' || num > Integer.MAX_VALUE) break;
            int length = res.size();
            if (length < 2 || res.get(length - 1) + res.get(length - 2) == num) {
                res.add((int) num);
                if (dfs(s, i + 1, end, res)) return true;
                res.remove(length);
            }
        }
        return false;
    }
}
