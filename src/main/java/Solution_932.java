package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_932 {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> temp = res.stream().filter(a -> a * 2 - 1 <= N).map(a -> a * 2 - 1).collect(Collectors.toList());
            res.stream().filter(a -> a * 2 <= N).map(a -> a * 2).forEach(temp::add);
            res = temp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
