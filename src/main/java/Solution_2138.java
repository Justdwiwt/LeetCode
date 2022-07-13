package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2138 {
    public String[] divideString(String s, int k, char fill) {
        while (s.length() % k != 0)
            s = String.format("%s%s", s, fill);
        List<String> res = new ArrayList<>((s.length() + k - 1) / k);
        for (int start = 0; start < s.length(); start += k)
            res.add(s.substring(start, Math.min(s.length(), start + k)));
        return res.toArray(new String[0]);
    }
}
