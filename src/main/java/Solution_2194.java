package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2194 {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        for (char c = s.charAt(0); c <= s.charAt(3); c++)
            for (int r = Integer.parseInt(s.substring(1, 2)); r <= Integer.parseInt(s.substring(4, 5)); r++)
                res.add("" + c + r);
        return res;
    }
}
