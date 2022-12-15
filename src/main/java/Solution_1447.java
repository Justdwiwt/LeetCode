package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1447 {
    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        if (n == 1) return new ArrayList<>();
        List<String> res = IntStream.rangeClosed(2, n).mapToObj(i -> 1 + "/" + i).collect(Collectors.toList());
        for (int i = 2; i <= n; i += 1)
            for (int j = i + 1; j <= n; j += 1) {
                int gcd = gcd(j, i);
                if (gcd == 1) res.add(i + "/" + j);
            }
        return res;
    }
}
