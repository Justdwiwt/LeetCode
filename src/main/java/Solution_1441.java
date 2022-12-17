package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int idx = 1;
        for (int cur : target) {
            while (cur > idx) {
                res.add("Push");
                res.add("Pop");
                idx++;
            }
            res.add("Push");
            idx++;
        }
        return res;
    }
}
