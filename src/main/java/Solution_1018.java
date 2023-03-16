package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int j : A) {
            num <<= 1;
            num += j;
            num %= 10;
            res.add(num % 5 == 0);
        }
        return res;
    }
}
