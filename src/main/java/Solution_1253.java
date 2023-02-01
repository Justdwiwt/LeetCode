package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = upper + lower;
        int u = upper;
        int l = lower;
        for (int col : colsum) {
            n -= col;
            if (col == 2) {
                u--;
                l--;
            }
            if (u < 0 || l < 0) break;
        }
        if (n != 0 || u < 0 || l < 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        IntStream.range(0, 2).mapToObj(res::get).forEach(list -> IntStream.range(0, colsum.length).mapToObj(j -> 0).forEach(list::add));
        for (int i = 0; i < colsum.length; i++)
            if (colsum[i] == 2) {
                res.get(0).set(i, 1);
                res.get(1).set(i, 1);
                upper--;
                lower--;
            }
        int i = 0;
        for (; i < colsum.length && upper > 0; i++)
            if (colsum[i] == 1) {
                res.get(0).set(i, 1);
                upper--;
            }
        for (; i < colsum.length; i++)
            if (colsum[i] == 1) {
                res.get(1).set(i, 1);
                lower--;
            }
        return res;
    }
}
