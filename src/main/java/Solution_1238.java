package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++)
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(res.get(j) + (1 << i));
        IntStream.range(0, res.size()).filter(i -> res.get(i) == start).findFirst().ifPresent(i -> Collections.rotate(res, -i));
        return res;
    }
}
