package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            int first = S.indexOf(c), last = S.lastIndexOf(c);
            for (int j = first + 1; j <= last; j++) {
                int t = S.lastIndexOf(S.charAt(j));
                if (t > last) last = t;
            }
            res.add(last - first + 1);
            i = last + 1;
        }
        return res;
    }
}
