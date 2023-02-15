package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] status = new int[s.length() + 1];
        IntStream.range(0, s.length()).forEach(i -> status[i + 1] = (status[i] ^ (1 << (s.charAt(i) - 'a'))));
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int count = 0, n = (status[query[1] + 1] ^ status[query[0]]);
            while (n != 0) {
                n = (n & (n - 1));
                count++;
            }
            res.add(count / 2 <= query[2]);
        }
        return res;
    }
}
