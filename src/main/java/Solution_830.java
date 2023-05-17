package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        S = S + "A";
        List<List<Integer>> res = new ArrayList<>();
        int begin = 0;
        for (int i = 1; i < S.length(); i++)
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (i - begin >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i - 1);
                    res.add(temp);
                }
                begin = i;
            }
        return res;
    }
}
