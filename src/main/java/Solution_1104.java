package main.java;

import java.util.LinkedList;
import java.util.List;

public class Solution_1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        int idx = 1;
        while (idx <= label) idx <<= 1;
        while (label != 0) {
            idx >>= 1;
            res.add(0, label);
            label = (label ^ idx - 1) >> 1;
        }
        return res;
    }
}
