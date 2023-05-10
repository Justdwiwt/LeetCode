package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] res = new int[quiet.length];
        List<List<Integer>> poor = new ArrayList<>();
        IntStream.range(0, quiet.length).forEach(i -> {
            poor.add(new ArrayList<>());
            res[i] = i;
        });
        int[] count = new int[quiet.length];
        IntStream.range(0, richer.length).forEach(i -> {
            poor.get(richer[i][0]).add(richer[i][1]);
            count[richer[i][1]]++;
        });
        List<Integer> list = IntStream.range(0, quiet.length).filter(i -> count[i] == 0).boxed().collect(Collectors.toList());
        int k = 0;
        while (k < list.size()) {
            int l = list.size();
            for (; k < l; k++) {
                List<Integer> p = poor.get(list.get(k));
                for (Integer integer : p) {
                    if (quiet[res[integer]] > quiet[res[list.get(k)]]) res[integer] = res[list.get(k)];
                    count[integer]--;
                    if (count[integer] == 0) list.add(integer);
                }
            }
        }
        return res;
    }
}
