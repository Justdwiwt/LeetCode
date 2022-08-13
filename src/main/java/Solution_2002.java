package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2002 {
    public int maxProduct(String s) {
        Map<Integer, Integer> palSeq = new HashMap<>();
        int len = (1 << s.length()) - 1;
        for (int mask = 1; mask <= len; mask++) {
            StringBuilder subSeq = new StringBuilder();
            for (int j = 0; j < s.length(); j++)
                if ((mask & (1 << j)) != 0)
                    subSeq.append(s.charAt(j));

            if (isPalindrome(subSeq.toString()))
                palSeq.put(mask, subSeq.length());
        }
        int mx = 0;
        for (Integer m1 : palSeq.keySet())
            for (Integer m2 : palSeq.keySet())
                if ((m1 & m2) == 0)
                    mx = Math.max(mx, (palSeq.get(m1) * palSeq.get(m2)));
        return mx;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;
        while (l < h)
            if (s.charAt(l++) != s.charAt(h--))
                return false;
        return true;
    }
}
